package com.sophos.poc.wsrestauditoriaapi.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.data.annotation.Id;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-24T18:02:46.113Z")
public class Accion {

	  @JsonProperty("FechaCreacion")
	  private OffsetDateTime fechaCreacion = null;
	  
	  @Id 
	  @JsonProperty("IdSesion")
	  private String idSesion = null;

	  @JsonProperty("IdUsuario")
	  private String idUsuario = null;

	  @JsonProperty("TipoAccion")
	  private String tipoAccion = null;

	  @JsonProperty("DescripcionAccion")
	  private String descripcionAccion = null;

	  @JsonProperty("ModuloAplicacion")
	  private String moduloAplicacion = null;

	  @JsonProperty("IdProducto")
	  private String idProducto = null;

	  @JsonProperty("IdCategoria")
	  private String idCategoria = null;

	  public Accion fechaCreacion(OffsetDateTime fechaCreacion) {
	    this.fechaCreacion = fechaCreacion;
	    return this;
	  }

	  /**
	   * Get fechaCreacion
	   * @return fechaCreacion
	  **/
	  @ApiModelProperty(value = "")
	  @Valid
	  public OffsetDateTime getFechaCreacion() {
	    return fechaCreacion;
	  }

	  public void setFechaCreacion(OffsetDateTime fechaCreacion) {
	    this.fechaCreacion = fechaCreacion;
	  }

	  public Accion idSesion(String idSesion) {
	    this.idSesion = idSesion;
	    return this;
	  }

	  /**
	   * Get idSesion
	   * @return idSesion
	  **/
	  @ApiModelProperty(value = "")


	  public String getIdSesion() {
	    return idSesion;
	  }

	  public void setIdSesion(String idSesion) {
	    this.idSesion = idSesion;
	  }

	  public Accion idUsuario(String idUsuario) {
	    this.idUsuario = idUsuario;
	    return this;
	  }

	  /**
	   * Get idUsuario
	   * @return idUsuario
	  **/
	  @ApiModelProperty(value = "")


	  public String getIdUsuario() {
	    return idUsuario;
	  }

	  public void setIdUsuario(String idUsuario) {
	    this.idUsuario = idUsuario;
	  }

	  public Accion tipoAccion(String tipoAccion) {
	    this.tipoAccion = tipoAccion;
	    return this;
	  }

	  /**
	   * Get tipoAccion
	   * @return tipoAccion
	  **/
	  @ApiModelProperty(value = "")


	  public String getTipoAccion() {
	    return tipoAccion;
	  }

	  public void setTipoAccion(String tipoAccion) {
	    this.tipoAccion = tipoAccion;
	  }

	  public Accion descripcionAccion(String descripcionAccion) {
	    this.descripcionAccion = descripcionAccion;
	    return this;
	  }

	  /**
	   * Get descripcionAccion
	   * @return descripcionAccion
	  **/
	  @ApiModelProperty(value = "")


	  public String getDescripcionAccion() {
	    return descripcionAccion;
	  }

	  public void setDescripcionAccion(String descripcionAccion) {
	    this.descripcionAccion = descripcionAccion;
	  }

	  public Accion moduloAplicacion(String moduloAplicacion) {
	    this.moduloAplicacion = moduloAplicacion;
	    return this;
	  }

	  /**
	   * Get moduloAplicacion
	   * @return moduloAplicacion
	  **/
	  @ApiModelProperty(value = "")


	  public String getModuloAplicacion() {
	    return moduloAplicacion;
	  }

	  public void setModuloAplicacion(String moduloAplicacion) {
	    this.moduloAplicacion = moduloAplicacion;
	  }

	  public Accion idProducto(String idProducto) {
	    this.idProducto = idProducto;
	    return this;
	  }

	  /**
	   * Get idProducto
	   * @return idProducto
	  **/
	  @ApiModelProperty(value = "")


	  public String getIdProducto() {
	    return idProducto;
	  }

	  public void setIdProducto(String idProducto) {
	    this.idProducto = idProducto;
	  }

	  public Accion idCategoria(String idCategoria) {
	    this.idCategoria = idCategoria;
	    return this;
	  }

	  /**
	   * Get idCategoria
	   * @return idCategoria
	  **/
	  @ApiModelProperty(value = "")


	  public String getIdCategoria() {
	    return idCategoria;
	  }

	  public void setIdCategoria(String idCategoria) {
	    this.idCategoria = idCategoria;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    Accion accion = (Accion) o;
	    return Objects.equals(this.fechaCreacion, accion.fechaCreacion) &&
	        Objects.equals(this.idSesion, accion.idSesion) &&
	        Objects.equals(this.idUsuario, accion.idUsuario) &&
	        Objects.equals(this.tipoAccion, accion.tipoAccion) &&
	        Objects.equals(this.descripcionAccion, accion.descripcionAccion) &&
	        Objects.equals(this.moduloAplicacion, accion.moduloAplicacion) &&
	        Objects.equals(this.idProducto, accion.idProducto) &&
	        Objects.equals(this.idCategoria, accion.idCategoria);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(fechaCreacion, idSesion, idUsuario, tipoAccion, descripcionAccion, moduloAplicacion, idProducto, idCategoria);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("{\n");
	    
	    sb.append("    \"FechaCreacion\": \"").append(toIndentedString(fechaCreacion)).append("\",\n");
	    sb.append("    \"IdSesion\": \"").append(toIndentedString(idSesion)).append("\",\n");
	    sb.append("    \"IdUsuario\": \"").append(toIndentedString(idUsuario)).append("\",\n");
	    sb.append("    \"TipoAccion\": \"").append(toIndentedString(tipoAccion)).append("\",\n");
	    sb.append("    \"DescripcionAccion\": \"").append(toIndentedString(descripcionAccion)).append("\",\n");
	    sb.append("    \"ModuloAplicacion\": \"").append(toIndentedString(moduloAplicacion)).append("\",\n");
	    sb.append("    \"IdProducto\": ").append(toIndentedString(idProducto)).append(",\n");
	    sb.append("    \"IdCategoria\": ").append(toIndentedString(idCategoria)).append("\n");
	    sb.append("}");
	    return sb.toString();
	  }

	  /**
	   * Convert the given object to string with each line indented by 4 spaces
	   * (except the first line).
	   */
	  private String toIndentedString(java.lang.Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }
}
