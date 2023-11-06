package xd;

public class datacelular {
	int id;
	String marca;
	String modelo;
	String sistema;
	String procesador;
	celular dc = new celular();

	public boolean insertar() {
		if (dc.insertar(this)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean eliminar() {
		if (dc.eliminar(this.getId())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean actualizar() {
		if (dc.actualizar(this)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean cargar() {
		if (dc.cargar(this)) {
			return true;
		} else {
			return false;
		}

	}

	public datacelular() {
	}

	public datacelular(int id, String marca, String modelo, String sistema, String procesador) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.sistema = sistema;
		this.procesador = procesador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

}
