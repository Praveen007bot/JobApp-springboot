package com.praveen.firstApp.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);
    Review getReview(Long companyId, Long reviewId);
    boolean updateReview(Long companyId, Long reviewId, Review newReview);

    boolean deleteReview(Long companyId, Long reviewId);
}
