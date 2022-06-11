package com.wolfhack.diploma.service;

import com.wolfhack.diploma.models.users.Wishlist;
import com.wolfhack.diploma.repository.UserRepository;
import com.wolfhack.diploma.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@RequiredArgsConstructor
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;

    public void addProductToWishlist(Wishlist wishlist) {
        wishlist.setCreatedAt(new Date());
        wishlistRepository.save(wishlist);
    }

    public Page<Wishlist> getUserWishlist(Pageable pageable, Long userId) {
        return wishlistRepository.findAllByUserId(pageable, userId);
    }

}
