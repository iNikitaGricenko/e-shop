package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.users.Wishlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    Page<Wishlist> findAllByUserId(Pageable pageable, Long userId);

}
