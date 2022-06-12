package com.wolfhack.diploma.Controllers.rest;

import com.wolfhack.diploma.models.products.Cpu;
import com.wolfhack.diploma.models.products.Product;
import com.wolfhack.diploma.models.users.Wishlist;
import com.wolfhack.diploma.service.WishlistService;
import com.wolfhack.diploma.validator.AuthenticationConstraint;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/accessories/api/user/wishlist")
@RequiredArgsConstructor
public class WishlistRestController {

    private final WishlistService wishlistService;

    @GetMapping
    public Page<Product> getUserWishlist(Pageable pageable, @AuthenticationConstraint Authentication authentication, Long userId) {
        return wishlistService.getUserWishlist(pageable, userId);
    }

    @GetMapping("/{userId}")
    public Page<Product> geWishlistByUserId(Pageable pageable, @AuthenticationConstraint Authentication authentication, @PathVariable("userId") Long userId) {
        return wishlistService.getUserWishlist(pageable, userId);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void addProductToUserWishlist(@RequestBody Wishlist wishlist) {
        wishlistService.addProductToWishlist(wishlist);
    }

}
