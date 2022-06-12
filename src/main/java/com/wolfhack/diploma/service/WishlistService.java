package com.wolfhack.diploma.service;

import com.wolfhack.diploma.models.products.Product;
import com.wolfhack.diploma.models.users.Wishlist;
import com.wolfhack.diploma.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final ProductRepository productRepository;
    public void addProductToWishlist(Wishlist wishlist) {
        wishlist.setCreatedAt(new Date());
        wishlistRepository.save(wishlist);
    }

    public Page<Product> getUserWishlist(Pageable pageable, Long userId) {
        List<Wishlist> content = wishlistRepository.findAllByUserId(pageable, userId).getContent();
        List<String> productIds = content.stream()
                .map(Wishlist::getProductId)
                .collect(toList());

        return productRepository.findAllById(pageable, productIds);
    }

}
