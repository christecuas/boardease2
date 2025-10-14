package com.example.mock;

public class ReviewModel {
    private int id;
    private int rating;
    private String comment;
    private String date;
    private String reviewerName;
    private int boardingHouseId;

    public ReviewModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public int getBoardingHouseId() {
        return boardingHouseId;
    }

    public void setBoardingHouseId(int boardingHouseId) {
        this.boardingHouseId = boardingHouseId;
    }
}
