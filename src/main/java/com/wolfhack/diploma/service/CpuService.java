package com.wolfhack.diploma.service;

import com.wolfhack.diploma.models.products.Cpu;
import com.wolfhack.diploma.repository.CpuRepository;
import com.wolfhack.diploma.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class CpuService {

    private final CpuRepository cpuRepository;

    public Page<Cpu> findAll(Pageable pageable) {
        return cpuRepository.findAll(pageable);
    }

    public void save(Cpu cpu, MultipartFile[] photos) throws IOException {
        Cpu savedLaptop = cpuRepository.save(cpu);
        String uploadDir = "photos/product-photos/"+savedLaptop.getCatalog()+savedLaptop.getName()+"_"+savedLaptop.getId();
        FileUploadUtil.trySaveFile(uploadDir, savedLaptop.getPhotoNames(), photos);
    }

    public boolean exists(Cpu cpu) {
        return cpuRepository.existsProductByNameAndModel(cpu.getName(), cpu.getModel());
    }

}
