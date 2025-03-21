package com.tenpo.prueba.boot.web.model;
public class WebResponseEntity<T> {

    private String mensaje;
    private T data;

    public WebResponseEntity() {
    }



    public String getMensaje() {
        return this.mensaje;
    }


    public T getData() {
        return this.data;
    }



    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


    public void setData(T data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        else if(!(o instanceof WebResponseEntity)) {
            return false;
        }
        else {
            WebResponseEntity<?> other = (WebResponseEntity)o;
            if(!other.canEqual(this)) {
                return false;
            }
            else {

                label57:
                {
                    Object this$mensaje = this.getMensaje();
                    Object other$mensaje = other.getMensaje();
                    if(this$mensaje == null) {
                        if(other$mensaje == null) {
                            break label57;
                        }
                    }
                    else if(this$mensaje.equals(other$mensaje)) {
                        break label57;
                    }

                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if(this$data == null) {
                    return other$data == null;
                }
                else return this$data.equals(other$data);
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof WebResponseEntity;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $message = this.getMensaje();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "WebResponseEntity(, mensaje=" + this.getMensaje() + ", data=" + this.getData() + ")";
    }

}
