package com.sngular.multifileplugin.reactivegeneration.model;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import com.sngular.multifileplugin.reactivegeneration.model.exception.ModelClassException;
import com.sngular.multifileplugin.reactivegeneration.model.customvalidator.NotNull;

@JsonDeserialize(builder = ApiErrorDTO.ApiErrorDTOBuilder.class)
public class ApiErrorDTO {

  @JsonProperty(value ="code")
  @NotNull
  private final Integer code;
  @JsonProperty(value ="message")
  @NotNull
  private final String message;

  private ApiErrorDTO(Integer code, String message) {
    this.code = code;
    this.message = message;

    validateRequiredAttributes();
  }

  private ApiErrorDTO(ApiErrorDTOBuilder builder) {
    this.code = builder.code;
    this.message = builder.message;

    validateRequiredAttributes();
  }

  public static ApiErrorDTO.ApiErrorDTOBuilder builder() {
    return new ApiErrorDTO.ApiErrorDTOBuilder();
  }

  @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
  public static class ApiErrorDTOBuilder {

    private Integer code;
    private String message;

    public ApiErrorDTO.ApiErrorDTOBuilder code(Integer code) {
      this.code = code;
      return this;
    }

    public ApiErrorDTO.ApiErrorDTOBuilder message(String message) {
      this.message = message;
      return this;
    }

    public ApiErrorDTO build() {
      ApiErrorDTO apiErrorDTO = new ApiErrorDTO(this);
      return apiErrorDTO;
    }
  }

  /**
  * Get code
  * @return code
  */
  @Schema(name = "code", required = true)
  public Integer getCode() {
    return code;
  }

  /**
  * Get message
  * @return message
  */
  @Schema(name = "message", required = true)
  public String getMessage() {
    return message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiErrorDTO apiErrorDTO = (ApiErrorDTO) o;
    return Objects.equals(this.code, apiErrorDTO.code) && Objects.equals(this.message, apiErrorDTO.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiErrorDTO {\n");
    sb.append(" code: ").append(toIndentedString(code)).append("\n");
    sb.append(" message: ").append(toIndentedString(message)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
  * Convert the given object to string with each line indented by 4 spaces
  * (except the first line).
  */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n ");
  }


  private void validateRequiredAttributes() {
    boolean satisfiedCondition = true;

    if (!Objects.nonNull(this.code)) {
      satisfiedCondition = false;
    } else if (!Objects.nonNull(this.message)) {
      satisfiedCondition = false;
    }

    if (!satisfiedCondition) {
      throw new ModelClassException("ApiErrorDTO");
    }
  }

}
