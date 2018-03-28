package unitary.data;

import com.prosegur.rulesEngine.factsmodel.costeo.FactBeneficioDetalle;
import com.prosegur.rulesEngine.factsmodel.costeo.FactCategoriaSalarial;
import com.prosegur.rulesEngine.factsmodel.costeo.FactCliente;
import com.prosegur.rulesEngine.factsmodel.costeo.FactEsquemaOperativo;
import com.prosegur.rulesEngine.factsmodel.costeo.FactMedioAuxiliar;
import com.prosegur.rulesEngine.factsmodel.costeo.FactMedioAuxiliarDetalle;
import com.prosegur.rulesEngine.factsmodel.costeo.FactOT;
import com.prosegur.rulesEngine.factsmodel.costeo.FactParams;
import com.prosegur.rulesEngine.factsmodel.costeo.FactSubcliente;
import com.prosegur.rulesEngine.factsmodel.costeo.FactTipoPuesto;

public class DataBase {
	
	public static FactTipoPuesto getTipoPuesto_VD() { 
		FactTipoPuesto tipoPuesto = new FactTipoPuesto();
		tipoPuesto.setId("VD");
		tipoPuesto.setDescripcion("Vigilante Patrimonial - VIGILÂNCIA");
		
		return tipoPuesto;
	}

	public static FactTipoPuesto getTipoPuesto_INV1() {
		FactTipoPuesto tipoPuesto = new FactTipoPuesto();
		tipoPuesto.setId("IN V1");
		tipoPuesto.setDescripcion("Inspetor Patrimonial 1 - VIGILÂNCIA");
		
		return tipoPuesto;
	}

	public static FactTipoPuesto getTipoPuesto_SUP_CVRD_V() { 
		FactTipoPuesto tipoPuesto = new FactTipoPuesto();
		tipoPuesto.setId("SUP CVRD V");
		tipoPuesto.setDescripcion("Supervisor CVRD - VIGILÂNCIA");
		
		return tipoPuesto;
	}
	
	public static FactCategoriaSalarial getCategoriaSalarial_SVIG_MG() {
		FactCategoriaSalarial factCategoriaSalarial_SVIGMG = new FactCategoriaSalarial();
		factCategoriaSalarial_SVIGMG.setId("SVIG - MG");	
		
		return factCategoriaSalarial_SVIGMG;
	}
	
	public static FactEsquemaOperativo getEsquemaOperativo001_12() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setOt(getOT001());
		factEsquemaOperativo.setId(12);
		factEsquemaOperativo.setIdTipoPuesto("VD");
		factEsquemaOperativo.setIdCategoriaSalarial("SVIG - MG");
		factEsquemaOperativo.setIdEscala("12X36");
		factEsquemaOperativo.setNumeroPersonasReal(4);
		
		factEsquemaOperativo.setHorasAdicNocturno(212.92);
		factEsquemaOperativo.setHorasExtrasEspeciales(0);
		
//		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (220, 4, 1325.12, 5300.48));
//		factEsquemaOperativo.addTarifa(new FactTarifaDetalle(30, "GT:POSTO17", 1, 17822.06, 17822.06));
		
		factEsquemaOperativo.setPorcentualHoraEspecial(50);
		
		return factEsquemaOperativo;
	}
	
	public static FactEsquemaOperativo getEsquemaOperativo002_12() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setOt(getOT002());
		factEsquemaOperativo.setId(12);
		factEsquemaOperativo.setIdTipoPuesto("VD");
		factEsquemaOperativo.setIdCategoriaSalarial("SVIG - MG");
		factEsquemaOperativo.setIdEscala("12X36");
		factEsquemaOperativo.setNumeroPersonasReal(4);
		
		factEsquemaOperativo.setHorasAdicNocturno(212.92);
		factEsquemaOperativo.setHorasExtrasEspeciales(0);
		
		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (170, 30, 12, 360));
		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (176, 4, 100, 400));
		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (175, 4, 55, 220));
		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (200, 4, 125, 500));
		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (220, 4, 1325.12, 5300.48));
		
//		factEsquemaOperativo.addTarifa(new FactTarifaDetalle(30, "GT:POSTO17", 1, 17822.06, 17822.06));
		
		factEsquemaOperativo.setPorcentualHoraEspecial(50);
		
		return factEsquemaOperativo;
	}
	
	
	public static FactEsquemaOperativo getEsquemaOperativo001_13() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setOt(getOT001());
		factEsquemaOperativo.setId(12);
		factEsquemaOperativo.setIdTipoPuesto("VD");
		factEsquemaOperativo.setIdCategoriaSalarial("SVIG - MG");
		factEsquemaOperativo.setIdEscala("12X36");
		factEsquemaOperativo.setNumeroPersonasReal(4);
		
		factEsquemaOperativo.setHorasAdicNocturno(212.92);
		factEsquemaOperativo.setHorasExtrasEspeciales(0);
		
		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (176, 4, 200, 800));
		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (123, 4, 725.12, 2900.48));
//		factEsquemaOperativo.addTarifa(new FactTarifaDetalle(34, "GT:POSTO17", 1, 42.62, 42.62));
		
		factEsquemaOperativo.setPorcentualHoraEspecial(50);
		
		return factEsquemaOperativo;
	}
	
	public static FactEsquemaOperativo getEsquemaOperativo002_13() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setOt(getOT002());
		factEsquemaOperativo.setId(13);
		factEsquemaOperativo.setIdTipoPuesto("VD");
		factEsquemaOperativo.setIdCategoriaSalarial("SVIG - MG");
		factEsquemaOperativo.setIdEscala("12X36");
		factEsquemaOperativo.setNumeroPersonasReal(4);
		
		factEsquemaOperativo.setHorasAdicNocturno(212.92);
		factEsquemaOperativo.setHorasExtrasEspeciales(0);
		
		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (175, 4, 75, 300));
		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (176, 4, 200, 800));
		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (123, 4, 725.12, 2900.48));
		
//		factEsquemaOperativo.addTarifa(new FactTarifaDetalle(34, "GT:POSTO17", 1, 42.62, 42.62));
		
		factEsquemaOperativo.setPorcentualHoraEspecial(50);
		
		return factEsquemaOperativo;
	}
	
	public static FactEsquemaOperativo getEsquemaOperativo001_17() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setOt(getOT001());
		factEsquemaOperativo.setId(17);
		factEsquemaOperativo.setIdTipoPuesto("VD");
		factEsquemaOperativo.setIdCategoriaSalarial("SVIG - MG");
		factEsquemaOperativo.setIdEscala("12X36");
//		factEsquemaOperativo.setNumeroPersonas(4);
		factEsquemaOperativo.setNumeroPersonasReal(4);
//		factEsquemaOperativo.setNumeroTurnosMes(60);
		
		factEsquemaOperativo.setHorasAdicNocturno(212.92);
		factEsquemaOperativo.setHorasExtrasEspeciales(0);

		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (100, 4, 1177.76, 4711.04));
		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (110, 4, 1300, 5200));
		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (180, 4, 60, 240));
		
		factEsquemaOperativo.addMedioAuxiliar(new FactMedioAuxiliarDetalle ("000029", 1, 0.91, 0.91));
		
		factEsquemaOperativo.setPorcentualHoraEspecial(50);
		
		return factEsquemaOperativo;
	}

	public static FactEsquemaOperativo getEsquemaOperativo001_18() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setOt(getOT001());
		factEsquemaOperativo.setId(18);
		factEsquemaOperativo.setIdTipoPuesto("VD");
		factEsquemaOperativo.setIdCategoriaSalarial("SVIG - MG");
		factEsquemaOperativo.setIdEscala("12X36");
//		factEsquemaOperativo.setNumeroPersonas(4);
		factEsquemaOperativo.setNumeroPersonasReal(4);
//		factEsquemaOperativo.setNumeroTurnosMes(60);
		
		factEsquemaOperativo.setHorasAdicNocturno(212.92);
		factEsquemaOperativo.setHorasExtrasEspeciales(0);
		
		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (100, 4, 1177.76, 4711.04));
		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (110, 4, 1300, 5200));
		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (180, 4, 60, 240));
		
		factEsquemaOperativo.addMedioAuxiliar(new FactMedioAuxiliarDetalle ("000029", 1, 0.91, 0.91));
		
		factEsquemaOperativo.setPorcentualHoraEspecial(50);
		
		return factEsquemaOperativo;
	}
	
	public static FactEsquemaOperativo getEsquemaOperativo001_20() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setOt(getOT001());
		factEsquemaOperativo.setId(20);
		factEsquemaOperativo.setIdTipoPuesto("IN V1");
		factEsquemaOperativo.setIdCategoriaSalarial("SVIG - MG");
		factEsquemaOperativo.setIdEscala("12X36");
//		factEsquemaOperativo.setNumeroPersonas(4);
		factEsquemaOperativo.setNumeroPersonasReal(4);
//		factEsquemaOperativo.setNumeroTurnosMes(60);
		
		factEsquemaOperativo.setHorasAdicNocturno(212.92);
		factEsquemaOperativo.setHorasExtrasEspeciales(0);
		
		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (100, 4, 1498.31, 5993.24));
		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (110, 4, 1301.22, 5204.88));
		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (180, 4, 100, 400));
		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (195, 2, 150, 300));
				
		factEsquemaOperativo.addMedioAuxiliar(new FactMedioAuxiliarDetalle ("000093", 4, 13, 52));
		
		factEsquemaOperativo.setPorcentualHoraEspecial(60);
		
		return factEsquemaOperativo;
	}	
	
	public static FactEsquemaOperativo getEsquemaOperativo001_40() {
		FactEsquemaOperativo factEsquemaOperativo = new FactEsquemaOperativo();
		factEsquemaOperativo.setOt(getOT001());
		factEsquemaOperativo.setId(40);
		factEsquemaOperativo.setIdTipoPuesto("SUP CVRD V");
		factEsquemaOperativo.setIdCategoriaSalarial("SVIG - MG");
		factEsquemaOperativo.setIdEscala("5X2");
		factEsquemaOperativo.setNumeroPersonasReal(1);
		
		factEsquemaOperativo.setHorasExtrasEspeciales(0);
		
		factEsquemaOperativo.addBeneficio(new FactBeneficioDetalle (100, 1, 1722.22, 1722.22));

		return factEsquemaOperativo;
	}	
	
	
	public static FactOT getOT001() {
		FactOT factOT = new FactOT();
		factOT.setEmpresa("01");

		FactCliente cliente = new FactCliente();
		cliente.setId("25");
		
		FactSubcliente subcliente = new FactSubcliente ();
		subcliente.setId("02");
		subcliente.setPais("01");
		subcliente.setFilial("01");
		subcliente.setEstado("04");
		subcliente.setCiudad("25");
		
		factOT.setCliente(cliente);
		factOT.setSubcliente(subcliente);
		
		factOT.addBeneficio(new FactBeneficioDetalle (170, 30, 10, 300));
		factOT.addBeneficio(new FactBeneficioDetalle (175, 12, 60, 720));
		factOT.addBeneficio(new FactBeneficioDetalle (176, 5, 100, 500));
		factOT.addBeneficio(new FactBeneficioDetalle (200, 5, 100, 500));
		
		factOT.addMedioAuxiliar(new FactMedioAuxiliarDetalle ("000288", 1, 4.8, 4.8));
		
		return factOT;
	}	
	
	public static FactParams getParams001() {
		FactParams factParams = new FactParams();
		factParams.setMargenInformado(30d);
		
		return factParams;
	}	
	
	public static FactOT getOT002() {
		FactOT factOT = new FactOT();
		factOT.setEmpresa("01");
		
		FactCliente cliente = new FactCliente();
		cliente.setId("25");
		
		FactSubcliente subcliente = new FactSubcliente ();
		subcliente.setId("02");
		subcliente.setPais("01");
		subcliente.setFilial("01");
		subcliente.setEstado("04");
		subcliente.setCiudad("21");
		
		factOT.setCliente(cliente);
		factOT.setSubcliente(subcliente);
		
		factOT.addMedioAuxiliar(new FactMedioAuxiliarDetalle ("000288", 1, 4.8, 4.8));
		
		return factOT;
	}	
	
	public static FactMedioAuxiliar getMedioAuxiliar000288 () {
		return new FactMedioAuxiliar ("000288", "COFRE AÇO C FEC ELET C AUDITORIA N SECURITY-M H33");
	}

	public static FactMedioAuxiliar getMedioAuxiliar000029 () {
		return new FactMedioAuxiliar ("000029", "CAPA DE CHUVA PVC FORRADA PRETA");
	}

	public static FactMedioAuxiliar getMedioAuxiliar000093 () {
		return new FactMedioAuxiliar ("000093", "CREME (PROTETOR SOLAR) LUVEX - FATOR 58");
	}
	
	
	
	
}

