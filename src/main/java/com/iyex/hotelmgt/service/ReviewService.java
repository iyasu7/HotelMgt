package com.iyex.hotelmgt.service;

import com.iyex.hotelmgt.domain.Review;
import com.iyex.hotelmgt.domain.account.User;
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
    public Review saveReview(Review review,User user){
        review.setUser(user);
        return reviewRepo.save(review);
    }
    //Update
    public Review updateReview(Long id, Review updateReview){
        Review review = reviewRepo.findById(id).orElseThrow(()->new NoSuchElementException("Review with id " + id + " not found"));
        review.setComment(updateReview.getComment());
        // If user changes a review,the likes button are removed
        review.setLikes(new HashSet<>());
        return review;
    }
    public Review likeReview(Long reviewId, User user){
        // user is the UserPrincipal
        Review review = getReviewById(reviewId);
        if (!review.getLikes().contains(user)){
            review.like(user);
            reviewRepo.save(review);
        }
        return review;
    }
    public Review removelikeReview(Long reviewId,User user){
        // user is the UserPrincipal
        Review review = getReviewById(reviewId);
        if(review.getLikes().contains(user)){
            review.dislike(user);
            reviewRepo.save(review);
        }
        return review;
    }

    public String deleteById(Long id){
        reviewRepo.deleteById(id);
        return "Review with id " + id + " was Deleted!!";
    }
}
