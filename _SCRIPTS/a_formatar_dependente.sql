IF OBJECT_ID('getAgenteMercadoDadosAgente', 'IF') IS NOT NULL
BEGIN
    DROP FUNCTION [dbo].[getAgenteMercadoDadosAgente]
END
GO

DECLARE @MyHierarchy Hierarchy;

CREATE FUNCTION [dbo].[getAgenteMercadoDadosAgente]()
RETURNS TABLE
AS
RETURN
    SELECT
        agteMercdDepdtPlanjFincr.nPssoaDepdtPlanjFincr AS tAgteMercdDepdtPlanjFincr_nPssoaDepdtPlanjFincr,
        agteMercdDepdtPlanjFincr.nAgteMercdPlanjFincr AS tAgteMercdDepdtPlanjFincr_nAgteMercdPlanjFincr,
        agteMercdPlanjFincr.nAgteMercdPlanjFincr AS tAgteMercdPlanjFincr_nAgteMercdPlanjFincr,
        agteMercdPlanjFincr.cBco AS tAgteMercdPlanjFincr_cBco,
        agteMercdPlanjFincr.iAgteMercdPlanjFincr AS tAgteMercdPlanjFincr_iAgteMercdPlanjFincr,
        agteMercdPlanjFincr.cUsuarIncl AS tAgteMercdPlanjFincr_cUsuarIncl,
        agteMercdPlanjFincr.hInclReg AS tAgteMercdPlanjFincr_hInclReg
    FROM [dbo].[tAgteMercdDepdtPlanjFincr] AS agteMercdDepdtPlanjFincr
    INNER JOIN [dbo].[tAgteMercdPlanjFincr] AS agteMercdPlanjFincr
        ON agteMercdDepdtPlanjFincr.nAgteMercdPlanjFincr = agteMercdPlanjFincr.nAgteMercdPlanjFincr;
GO

CREATE FUNCTION [dbo].[getFormatarDependente]()
RETURNS TABLE
AS
RETURN
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
    FROM [dbo].[tPssoaDepdtPlanjFincr] as tPssoaDepdtPlanjFincr
    ORDER BY tPssoaDepdtPlanjFincr.nPssoaDepdtPlanjFincr;
GO

--Precisa fazer o cursor e juntar com a function acima



select * from getAgenteMercadoDadosAgente() agtMerDAgt;



