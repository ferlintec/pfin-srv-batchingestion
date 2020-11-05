package br.com.bradesco.pfiningestion.FormatarDependente.vos;

import lombok.Data;

@Data
public class DependenteVO {
    private Integer nPssoaDepdtPlanjFincr;
    private Integer nPssoaPlanjFincr;
    private Integer cCategVnclo;
    private Integer cTpoVnclo;
    private Integer cIndcdDepdcPssoa;
    private Integer cCpfDepdtPssoaPlanjFincr;
    private Integer cCtrlCpfDepdtPssoaPlanjFincr;
    private String dNascDepdtPssoaPlanjFincr;
    private String rInfoFincrDepdt;
    private Integer cSiteReg;
    private String cUsuarIncl;
    private String hInclReg;
    private String hUltAltReg;
}
