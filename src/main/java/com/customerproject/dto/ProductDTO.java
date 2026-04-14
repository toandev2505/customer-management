package com.customerproject.dto;

import com.customerproject.entity.Direction;
import com.customerproject.entity.StatusOfProduct;
import com.customerproject.entity.TypeOfProduct;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

public class ProductDTO extends BaseDTO<ProductDTO> {
    private String title;
    private TypeOfProduct type;
    private String address;
    private List<Long> wardId;
    private BigDecimal price;
    private Double area;
    private Integer bedrooms;
    private Direction direction;
    private StatusOfProduct status;
    private String imageName;
    private String imageType;
    private String base64Image;
    private MultipartFile imageFile;

    private Long provinceId;
    private String wardName;
    private String provinceName;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;

    private Double aiScore;
    private String aiLabel;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TypeOfProduct getType() {
        return type;
    }

    public void setType(TypeOfProduct type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Long> getWardId() {
        return wardId;
    }

    public void setWardId(List<Long> wardId) {
        this.wardId = wardId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public StatusOfProduct getStatus() {
        return status;
    }

    public void setStatus(StatusOfProduct status) {
        this.status = status;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Double getAiScore() {
        return aiScore;
    }

    public void setAiScore(Double aiScore) {
        this.aiScore = aiScore;
    }

    public String getAiLabel() {
        return aiLabel;
    }

    public void setAiLabel(String aiLabel) {
        this.aiLabel = aiLabel;
    }
}
