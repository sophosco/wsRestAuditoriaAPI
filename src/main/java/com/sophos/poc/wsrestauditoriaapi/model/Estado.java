package com.sophos.poc.wsrestauditoriaapi.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-24T18:02:46.113Z")
public class Estado {

	 @JsonProperty("Codigo")
	  private String codigo = null;

	  @JsonProperty("Mensaje")
	  private String mensaje = null;

	  @JsonProperty("Excepcion")
	  private String excepcion = null;

	  public Estado codigo(String codigo) {
	    this.codigo = codigo;
	    return this;
	  }

	  /**
	   * Get codigo
	   * @return codigo
	  **/
	  @ApiModelProperty(value = "")
	  public String getCodigo() {
	    return codigo;
	  }

	  public void setCodigo(String codigo) {
	    this.codigo = codigo;
	  }

	  public Estado mensaje(String mensaje) {
	    this.mensaje = mensaje;
	    return this;
	  }

	  /**
	   * Get mensaje
	   * @return mensaje
	  **/
	  @ApiModelProperty(value = "")


	  public String getMensaje() {
	    return mensaje;
	  }

	  public void setMensaje(String mensaje) {
	    this.mensaje = mensaje;
	  }

	  public Estado excepcion(String excepcion) {
	    this.excepcion = excepcion;
	    return this;
	  }

	  /**
	   * Get excepcion
	   * @return excepcion
	  **/
	  @ApiModelProperty(value = "")


	  public String getExcepcion() {
	    return excepcion;
	  }

	  public void setExcepcion(String excepcion) {
	    this.excepcion = excepcion;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    Estado estado = (Estado) o;
	    return Objects.equals(this.codigo, estado.codigo) &&
	        Objects.equals(this.mensaje, estado.mensaje) &&
	        Objects.equals(this.excepcion, estado.excepcion);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(codigo, mensaje, excepcion);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class Estado {\n");
	    
	    sb.append("    codigo: ").append(toIndentedString(codigo)).append("\n");
	    sb.append("    mensaje: ").append(toIndentedString(mensaje)).append("\n");
	    sb.append("    excepcion: ").append(toIndentedString(excepcion)).append("\n");
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
