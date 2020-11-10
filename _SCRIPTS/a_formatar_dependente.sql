IF OBJECT_ID('AgenteMercadoDadosAgente', 'IF') IS NOT NULL
BEGIN
    DROP FUNCTION [dbo].[AgenteMercadoDadosAgente]
END
GO

CREATE FUNCTION [dbo].[AgenteMercadoDadosAgente]()
RETURNS TABLE
AS
RETURN
    SELECT
        agteMercdDepdtPlanjFincr.nPssoaDepdtPlanjFincr AS tAgteMercdDepdtPlanjFincr_nPssoaDepdtPlanjFincr,
        agteMercdDepdtPlanjFincr.nAgteMercdPlanjFincr AS tAgteMercdDepdtPlanjFincr_nAgteMercdPlanjFincr,
        agteMercdPlanjFincr.nAgteMercdPlanjFincr as tAgteMercdPlanjFincr_nAgteMercdPlanjFincr,
        agteMercdPlanjFincr.cBco as tAgteMercdPlanjFincr_cBco,
        agteMercdPlanjFincr.iAgteMercdPlanjFincr as tAgteMercdPlanjFincr_iAgteMercdPlanjFincr,
        agteMercdPlanjFincr.cUsuarIncl as tAgteMercdPlanjFincr_cUsuarIncl,
        agteMercdPlanjFincr.hInclReg as tAgteMercdPlanjFincr_hInclReg
    FROM [dbo].[tAgteMercdDepdtPlanjFincr] AS agteMercdDepdtPlanjFincr
    INNER JOIN [dbo].[tAgteMercdPlanjFincr] AS agteMercdPlanjFincr
        ON agteMercdDepdtPlanjFincr.nAgteMercdPlanjFincr = agteMercdPlanjFincr.nAgteMercdPlanjFincr


SELECT 
    [nPssoaDepdtPlanjFincr] as tPssoaDepdtPlanjFincr_nPssoaDepdtPlanjFincr,
    [nPssoaPlanjFincr] as tPssoaDepdtPlanjFincr_nPssoaPlanjFincr,
    [cCategVnclo] as tPssoaDepdtPlanjFincr_cCategVnclo,
    [cTpoVnclo] as tPssoaDepdtPlanjFincr_cTpoVnclo,
    [cIndcdDepdcPssoa] as tPssoaDepdtPlanjFincr_cIndcdDepdcPssoa,
    [cCpfDepdtPssoaPlanjFincr] as tPssoaDepdtPlanjFincr_cCpfDepdtPssoaPlanjFincr,
    [cCtrlCpfDepdtPssoaPlanjFincr] as tPssoaDepdtPlanjFincr_cCtrlCpfDepdtPssoaPlanjFincr,
    [dNascDepdtPssoaPlanjFincr] as tPssoaDepdtPlanjFincr_dNascDepdtPssoaPlanjFincr,
    [iPssoaDepdtPlanjFincr] as tPssoaDepdtPlanjFincr_iPssoaDepdtPlanjFincr,
    [rInfoFincrDepdt] as tPssoaDepdtPlanjFincr_rInfoFincrDepdt,
    [cSitReg] as tPssoaDepdtPlanjFincr_cSitReg,
    [cUsuarIncl] as tPssoaDepdtPlanjFincr_cUsuarIncl,
    [hInclReg] as tPssoaDepdtPlanjFincr_hInclReg,
    [hUltAltReg] as tPssoaDepdtPlanjFincr_hUltAltReg
FROM [dbo].[tPssoaDepdtPlanjFincr] as tPssoaDepdtPlanjFincr;


select * from AgenteMercadoDadosAgente();



