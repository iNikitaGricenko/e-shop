package com.wolfhack.diploma.service;

import com.wolfhack.diploma.models.products.Gpu;
import com.wolfhack.diploma.repository.GpuRepository;
import com.wolfhack.diploma.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class GpuService {

    private final GpuRepository gpuRepository;

    public Page<Gpu> findAll(Pageable pageable) {
        return gpuRepository.findAll(pageable);
    }

    public void save(Gpu gpu, MultipartFile[] photos) throws IOException {
        Gpu savedLaptop = gpuRepository.save(gpu);
        String uploadDir = "photos/product-photos/"+savedLaptop.getCatalog()+savedLaptop.getName()+"_"+savedLaptop.getId();
        FileUploadUtil.trySaveFile(uploadDir, savedLaptop.getPhotoNames(), photos);
    }

    public boolean exists(Gpu gpu) {
        return gpuRepository.existsProductByNameAndModel(gpu.getName(), gpu.getModel());
    }

}
