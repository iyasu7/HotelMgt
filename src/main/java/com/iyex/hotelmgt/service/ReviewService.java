package com.iyex.hotelmgt.service;

import com.iyex.hotelmgt.domain.Review;
import com.iyex.hotelmgt.domain.account.Guest;
import com.iyex.hotelmgt.repository.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepo reviewRepo;

    public Review getReviewById(Long id){
        return reviewRepo.findById(id).orElseThrow(()->new NoSuchElementException("Review with id " + id + " not found"));
    }
    public List<Review> getReviewsByHotelId(Long hotelId){
        return reviewRepo.findReviewByHotelId(hotelId);
    }
    public Review saveReview(Review review){
        return reviewRepo.save(review);
    }
    //Update
    public Review updateReview(Long id, Review updateReview){
        Review review = reviewRepo.findById(id).orElseThrow(()->new NoSuchElementException("Review with id " + id + " not found"));
        review.setReview(updateReview.getReview());
        // If user changes a review,the likes button are removed
        review.setLikes(new HashSet<>());
        return review;
    }
    public Review likeReview(Long reviewId, Guest guest){
        // guest is the UserPrincipal
        Review review = getReviewById(reviewId);
        if (!review.getLikes().contains(guest)){
            review.like(guest);
            reviewRepo.save(review);
        }
        return review;
    }
    public Review removelikeReview(Long reviewId,Guest guest){
        // guest is the UserPrincipal
        Review review = getReviewById(reviewId);
        if(review.getLikes().contains(guest)){
            review.dislike(guest);
            reviewRepo.save(review);
        }
        return review;
    }

    public String deleteById(Long id){
        reviewRepo.deleteById(id);
        return "Review with id " + id + " was Deleted!!";
    }
}
