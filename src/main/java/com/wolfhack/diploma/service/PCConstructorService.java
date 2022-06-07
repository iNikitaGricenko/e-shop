package com.wolfhack.diploma.service;

import com.wolfhack.diploma.models.products.*;
import com.wolfhack.diploma.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Formatter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
public class PCConstructorService {

    private final MotherboardRepository motherboardRepository;
    private final CpuRepository cpuRepository;
    private final GpuRepository gpuRepository;
    private final RamRepository ramRepository;
    private final SsdRepository ssdRepository;
    private final PowerSupplyRepository powerSupplyRepository;

    public Page<Motherboard> findMotherboardByCpuAndRamCompatible(Pageable pageable, Map<String, String> productsCode) {
        Page<Motherboard> motherboards = findMotherboardsByCpuCompatible(pageable, productsCode.get("cpu"));

        if (!productsCode.get("ram").equals("")) {
            Ram ram = ramRepository.findById(productsCode.get("ram"))
                    .orElseThrow();
            Formatter ramType = new Formatter()
                    .format("%s %s", ram.getType(), ram.getFormFactor());

        return new PageImpl<>(motherboards.getContent().stream()
                .filter(motherboard -> motherboard.getMemoryType().equals(ramType.toString()))
                .collect(toList()));
        }
        return motherboards;
    }

    public Page<Cpu> findCpuByMotherboardCompatible(Pageable pageable, String motherboardCode) {
        if (motherboardCode.equals("")) {
            return cpuRepository.findAll(pageable);
        }
        Motherboard motherboard = motherboardRepository.findById(motherboardCode)
                .orElseGet(Motherboard::new);
        return cpuRepository.findAllBySocket(pageable, motherboard.getSocket());
    }

    public Page<Ram> findRamByMotherboardCompatible(Pageable pageable, String motherboardCode) {
        if (motherboardCode.equals("")) {
            return ramRepository.findAll(pageable);
        }
        Motherboard motherboard = motherboardRepository.findById(motherboardCode)
                .orElseGet(Motherboard::new);
        return ramRepository.findAllByType(pageable, motherboard.getMemoryType().split(" ")[0]);
    }

    public Page<Gpu> findGpuByMotherboardCompatible(Pageable pageable, String motherboardCode) {
        if (motherboardCode.equals("")) {
            return gpuRepository.findAll(pageable);
        }
        Motherboard motherboard = motherboardRepository.findById(motherboardCode)
                .orElseGet(Motherboard::new);

        List<String> pciKeys = motherboard.getExternalPorts()
                .keySet().stream()
                .filter(s -> s.contains("PCI"))
                .collect(toList());
        List<String> existingPciExpress = pciKeys.stream()
                .peek(s -> s.replaceAll("PCI-E", "PCI Express"))
                .collect(toList());

        return gpuRepository.findAllByGpuInterfaceIsLike(pageable, existingPciExpress.get(0));
    }

    public Page<Ssd> findSsdByMotherboardCompatible(Pageable pageable, String motherboardCode) {
        if (motherboardCode.equals("")) {
            return ssdRepository.findAll(pageable);
        }
        Motherboard motherboard = motherboardRepository.findById(motherboardCode)
                .orElseGet(Motherboard::new);

        List<String> pciKeys = motherboard.getInjectedPorts()
                .keySet().stream()
                .filter(s -> s.contains("Кол-во слотов"))
                .peek(s -> s.replaceAll("Кол-во слотов ", ""))
                .collect(toList());

        return ssdRepository.findAllByFormFactorIsLike(pageable, pciKeys.get(0));
    }

    public Page<Motherboard> findMotherboardsByCpuCompatible(Pageable pageable, String cpuCode) {
        if (cpuCode.equals("")) {
            return motherboardRepository.findAll(pageable);
        }
        Cpu cpu = cpuRepository.findById(cpuCode)
                .orElseGet(Cpu::new);
        return motherboardRepository.findAllBySocket(pageable, cpu.getSocket());
    }

    public Page<Motherboard> findMotherboardsByRamCompatible(Pageable pageable, String ramCode) {
        if (ramCode.equals("")) {
            return motherboardRepository.findAll(pageable);
        }
        Ram ram = ramRepository.findById(ramCode)
                .orElseGet(Ram::new);
        Formatter ramType = new Formatter()
                .format("%s %s", ram.getType(), ram.getFormFactor());
        return motherboardRepository.findAllByMemoryType(pageable, ramType.toString());
    }

}
