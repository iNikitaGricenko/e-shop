package com.wolfhack.diploma.service;

import com.wolfhack.diploma.models.products.Cpu;
import com.wolfhack.diploma.models.products.Motherboard;
import com.wolfhack.diploma.models.products.Ram;
import com.wolfhack.diploma.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Formatter;
import java.util.Map;
import java.util.stream.Collectors;

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
                .collect(Collectors.toList()));
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
