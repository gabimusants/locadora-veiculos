package model;

public interface IVeiculo {
	String getPlaca();
	String getModelo();
	String getCor();
	int getAno();
	EStatusVeiculo getStatus();
	void setStatus(EStatusVeiculo status);
}
