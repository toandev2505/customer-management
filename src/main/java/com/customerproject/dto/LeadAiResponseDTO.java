package com.customerproject.dto;

public class LeadAiResponseDTO {
    private Double score;
    private String label;

    public LeadAiResponseDTO() {
    }

    public LeadAiResponseDTO(Double score, String label) {
        this.score = score;
        this.label = label;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
