package com.praveen.firstApp.review;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {

    ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review) {
        boolean created = reviewService.addReview(companyId, review);
        if (created)
            return new ResponseEntity<>("Review Added successfully", HttpStatus.CREATED);
        return new ResponseEntity<>("Review not saved", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReview(companyId, reviewId), HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review newReview) {
        boolean isUpdated = reviewService.updateReview(companyId, reviewId, newReview);
        if (isUpdated)
            return new ResponseEntity<>("Review is updated", HttpStatus.OK);
        return new ResponseEntity<>("Not Updated", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        boolean deleted = reviewService.deleteReview(companyId, reviewId);
        if (deleted)
            return new ResponseEntity<>("Review Deleted", HttpStatus.OK);
        return new ResponseEntity<>("Review not deleted", HttpStatus.NOT_FOUND);
    }
}
