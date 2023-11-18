package br.com.fiap.imunocheck.model.bean;

public class Vacinas {
		
	//21 vacinas
	
		//Infância
	 	private String bcg;
	    private String hepatiteB;
	    private String pentavalente;
	    private String vipVop;
	    private String pneumococica10Valente;
	    private String meningococicaC;
	    private String rotaVirus;
	    private String febreAmarela;
	    private String tripliceViral;
	    private String hepatiteA;
	    private String dtp;
	    private String varicela;
	    private String hpv;

	    // Adolescentes
	    private String hepatiteBAdlc;
	    private String hpvAdlc;

	    // Vida Adulta
	    private String tripliceViralReforco;
	    private String duplaDT;
	    private String hepatiteBDirecinado;
	    private String influenza;
	    private String pneumococicaDirecionado;
	    private String meningococicaDirecionado;
	    
		public String getBcg() {
			return bcg;
		}
		public void setBcg(String bcg) {
			this.bcg = bcg;
		}
		public String getHepatiteB() {
			return hepatiteB;
		}
		public void setHepatiteB(String hepatiteB) {
			this.hepatiteB = hepatiteB;
		}
		public String getPentavalente() {
			return pentavalente;
		}
		public void setPentavalente(String pentavalente) {
			this.pentavalente = pentavalente;
		}
		public String getVipVop() {
			return vipVop;
		}
		public void setVipVop(String vipVop) {
			this.vipVop = vipVop;
		}
		public String getPneumococica10Valente() {
			return pneumococica10Valente;
		}
		public void setPneumococica10Valente(String pneumococica10Valente) {
			this.pneumococica10Valente = pneumococica10Valente;
		}
		public String getMeningococicaC() {
			return meningococicaC;
		}
		public void setMeningococicaC(String meningococicaC) {
			this.meningococicaC = meningococicaC;
		}
		public String getRotaVirus() {
			return rotaVirus;
		}
		public void setRotaVirus(String rotaVirus) {
			this.rotaVirus = rotaVirus;
		}
		public String getFebreAmarela() {
			return febreAmarela;
		}
		public void setFebreAmarela(String febreAmarela) {
			this.febreAmarela = febreAmarela;
		}
		public String getTripliceViral() {
			return tripliceViral;
		}
		public void setTripliceViral(String tripliceViral) {
			this.tripliceViral = tripliceViral;
		}
		public String getHepatiteA() {
			return hepatiteA;
		}
		public void setHepatiteA(String hepatiteA) {
			this.hepatiteA = hepatiteA;
		}
		public String getDtp() {
			return dtp;
		}
		public void setDtp(String dtp) {
			this.dtp = dtp;
		}
		public String getVaricela() {
			return varicela;
		}
		public void setVaricela(String varicela) {
			this.varicela = varicela;
		}
		public String getHpv() {
			return hpv;
		}
		public void setHpv(String hpv) {
			this.hpv = hpv;
		}
		public String getHepatiteBAdlc() {
			return hepatiteBAdlc;
		}
		public void setHepatiteBAdlc(String hepatiteBAdlc) {
			this.hepatiteBAdlc = hepatiteBAdlc;
		}
		public String getHpvAdlc() {
			return hpvAdlc;
		}
		public void setHpvAdlc(String hpvAdlc) {
			this.hpvAdlc = hpvAdlc;
		}
		public String getTripliceViralReforco() {
			return tripliceViralReforco;
		}
		public void setTripliceViralReforco(String tripliceViralReforco) {
			this.tripliceViralReforco = tripliceViralReforco;
		}
		public String getDuplaDT() {
			return duplaDT;
		}
		public void setDuplaDT(String duplaDT) {
			this.duplaDT = duplaDT;
		}
		public String getHepatiteBDirecinado() {
			return hepatiteBDirecinado;
		}
		public void setHepatiteBDirecinado(String hepatiteBDirecinado) {
			this.hepatiteBDirecinado = hepatiteBDirecinado;
		}
		public String getInfluenza() {
			return influenza;
		}
		public void setInfluenza(String influenza) {
			this.influenza = influenza;
		}
		public String getPneumococicaDirecionado() {
			return pneumococicaDirecionado;
		}
		public void setPneumococicaDirecionado(String pneumococicaDirecionado) {
			this.pneumococicaDirecionado = pneumococicaDirecionado;
		}
		public String getMeningococicaDirecionado() {
			return meningococicaDirecionado;
		}
		public void setMeningococicaDirecionado(String meningococicaDirecionado) {
			this.meningococicaDirecionado = meningococicaDirecionado;
		}
		public Vacinas() {

		}
		public Vacinas(String bcg, String hepatiteB, String pentavalente, String vipVop, String pneumococica10Valente,
				String meningococicaC, String rotaVirus, String febreAmarela, String tripliceViral, String hepatiteA,
				String dtp, String varicela, String hpv, String hepatiteBAdlc, String hpvAdlc,
				String tripliceViralReforco, String duplaDT, String hepatiteBDirecinado, String influenza,
				String pneumococicaDirecionado, String meningococicaDirecionado) {
			this.bcg = bcg;
			this.hepatiteB = hepatiteB;
			this.pentavalente = pentavalente;
			this.vipVop = vipVop;
			this.pneumococica10Valente = pneumococica10Valente;
			this.meningococicaC = meningococicaC;
			this.rotaVirus = rotaVirus;
			this.febreAmarela = febreAmarela;
			this.tripliceViral = tripliceViral;
			this.hepatiteA = hepatiteA;
			this.dtp = dtp;
			this.varicela = varicela;
			this.hpv = hpv;
			this.hepatiteBAdlc = hepatiteBAdlc;
			this.hpvAdlc = hpvAdlc;
			this.tripliceViralReforco = tripliceViralReforco;
			this.duplaDT = duplaDT;
			this.hepatiteBDirecinado = hepatiteBDirecinado;
			this.influenza = influenza;
			this.pneumococicaDirecionado = pneumococicaDirecionado;
			this.meningococicaDirecionado = meningococicaDirecionado;
		}
		
	    
	    
	    

}
