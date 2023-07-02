package com.iyex.hotelmgt.resource;

import com.iyex.hotelmgt.domain.Hotel;
import com.iyex.hotelmgt.domain.Review;
import com.iyex.hotelmgt.service.HotelService;
import com.iyex.hotelmgt.service.ReviewService;
import com.iyex.hotelmgt.service.account.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    private final HotelService hotelService;
    private final GuestService guestService;

    @GetMapping("{hotelId}")
    public List<Review> getHotelReviews(@PathVariable Long hotelId){
        return reviewService.getReviewsByHotelId(hotelId);
    }
    @PostMapping("{hotelId}")
    public Review makeHotelReview(@PathVariable Long hotelId,@RequestBody Review review){
        Review newReview = reviewService.saveReview(review);
        Hotel hotel = hotelService.getHotel(hotelId);
        newReview.setHotel(hotel);
        return newReview;
    }
    @PutMapping("{reviewId}")
    public Review updateReview(@PathVariable Long reviewId,@RequestBody Review updateReview){
        Review review = reviewService.getReviewById(reviewId);
        review.setReview(updateReview.getReview());
        return review;
    }
//    @PostMapping("/{reviewId}/like")
//    public Review likeReview(@PathVariable Long reviewId, Authentication authentication) {
//        // Get the authenticated user(UserPrincipal)
//        Guest guest = guestService.getGuestByUsername(authentication.getName());
//
//        // Like the review
//        //for responseEntity
//// //       return ResponseEntity.ok().body(reviewService.likeReview(reviewId, guest));
//
//        return reviewService.likeReview(reviewId, guest);
//    }

//    @PostMapping("{reviewId}/unlike")
//    public Review unLikeReview(@PathVariable Long reviewId,Authentication authentication){
//        Guest guest = guestService.getGuestByUsername(authentication.getName());
//
//        return reviewService.removelikeReview(reviewId,guest);
//    }

    @DeleteMapping("/{reviewId}")
    public String deleteById(@PathVariable Long reviewId){
        return reviewService.deleteById(reviewId);
    }


}
