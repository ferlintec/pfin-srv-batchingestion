--************************************************************************
-- Function para retornar a lista de agente de mercado de 
-- um dependente.
-- Retorna os agentes de mercado em formato Json.
--************************************************************************
IF OBJECT_ID('getAgenteMercadoDadosAgenteByIdDependente', 'FN') IS NOT NULL
BEGIN
    DROP FUNCTION [dbo].[getAgenteMercadoDadosAgenteByIdDependente];
END
GO
CREATE FUNCTION [dbo].[getAgenteMercadoDadosAgenteByIdDependente](@ID_DEPENDENTE INT)
    RETURNS NVARCHAR
    AS
    BEGIN
        --PRINT CONVERT(VARCHAR, @ID_DEPENDENTE);
        DECLARE @JSON_FORMAT NVARCHAR(MAX);
        SET @JSON_FORMAT = (SELECT
            agteMercdDepdtPlanjFincr.nPssoaDepdtPlanjFincr AS tAgteMercdDepdtPlanjFincr_nPssoaDepdtPlanjFincr,
            agteMercdDepdtPlanjFincr.nAgteMercdPlanjFincr AS tAgteMercdDepdtPlanjFincr_nAgteMercdPlanjFincr,
            agteMercdPlanjFincr.nAgteMercdPlanjFincr AS tAgteMercdPlanjFincr_nAgteMercdPlanjFincr,
            agteMercdPlanjFincr.cBco AS tAgteMercdPlanjFincr_cBco,
            agteMercdPlanjFincr.iAgteMercdPlanjFincr AS tAgteMercdPlanjFincr_iAgteMercdPlanjFincr,
            agteMercdPlanjFincr.cUsuarIncl AS tAgteMercdPlanjFincr_cUsuarIncl,
            agteMercdPlanjFincr.hInclReg AS tAgteMercdPlanjFincr_hInclReg
        FROM [dbo].[tAgteMercdDepdtPlanjFincr] AS agteMercdDepdtPlanjFincr
        INNER JOIN [dbo].[tAgteMercdPlanjFincr] AS agteMercdPlanjFincr
            ON agteMercdDepdtPlanjFincr.nAgteMercdPlanjFincr = agteMercdPlanjFincr.nAgteMercdPlanjFincr
        WHERE agteMercdDepdtPlanjFincr.nPssoaDepdtPlanjFincr = @ID_DEPENDENTE
        FOR JSON PATH);

        RETURN @JSON_FORMAT;
    END
GO


--************************************************************************
-- Function para retornar a lista de dependentes
--************************************************************************
IF OBJECT_ID('getAllDependentes', 'IF') IS NOT NULL
BEGIN
    DROP FUNCTION [dbo].[getAllDependentes]
END
GO
CREATE FUNCTION [dbo].[getAllDependentes]()
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
   ;
GO

--Declaração da tabela temporária de dependente
DECLARE @DEPENDENTE_TABLE TABLE (
        tPssoaDepdtPlanjFincr_nPssoaDepdtPlanjFincr INT,
        tPssoaDepdtPlanjFincr_nPssoaPlanjFincr INT,
        tPssoaDepdtPlanjFincr_cCategVnclo [decimal](5, 0),
        tPssoaDepdtPlanjFincr_cTpoVnclo [decimal](2, 0),
        tPssoaDepdtPlanjFincr_cIndcdDepdcPssoa [decimal](1, 0),
        tPssoaDepdtPlanjFincr_cCpfDepdtPssoaPlanjFincr INT,
        tPssoaDepdtPlanjFincr_cCtrlCpfDepdtPssoaPlanjFincr TINYINT,
        tPssoaDepdtPlanjFincr_dNascDepdtPssoaPlanjFincr DATETIME,
        tPssoaDepdtPlanjFincr_iPssoaDepdtPlanjFincr VARCHAR(70),
        tPssoaDepdtPlanjFincr_rInfoFincrDepdt VARCHAR(255),
        tPssoaDepdtPlanjFincr_cSitReg [DECIMAL](1,0),
        tPssoaDepdtPlanjFincr_cUsuarIncl [CHAR](9),
        tPssoaDepdtPlanjFincr_hInclReg DATETIME,
        tPssoaDepdtPlanjFincr_hUltAltReg DATETIME,
        tAgteMercdDepdtPlanjFincr_json NVARCHAR(MAX)
)
 
--Variáveis temporárias
DECLARE @tPssoaDepdtPlanjFincr_nPssoaDepdtPlanjFincr INT,
        @tPssoaDepdtPlanjFincr_nPssoaPlanjFincr INT,
        @tPssoaDepdtPlanjFincr_cCategVnclo [decimal](5, 0),
        @tPssoaDepdtPlanjFincr_cTpoVnclo [decimal](2, 0),
        @tPssoaDepdtPlanjFincr_cIndcdDepdcPssoa [decimal](1, 0),
        @tPssoaDepdtPlanjFincr_cCpfDepdtPssoaPlanjFincr INT,
        @tPssoaDepdtPlanjFincr_cCtrlCpfDepdtPssoaPlanjFincr TINYINT,
        @tPssoaDepdtPlanjFincr_dNascDepdtPssoaPlanjFincr DATETIME,
        @@tPssoaDepdtPlanjFincr_iPssoaDepdtPlanjFincr VARCHAR(70),
        @tPssoaDepdtPlanjFincr_rInfoFincrDepdt VARCHAR(255),
        @tPssoaDepdtPlanjFincr_cSitReg [DECIMAL](1,0),
        @tPssoaDepdtPlanjFincr_cUsuarIncl [CHAR](9),
        @tPssoaDepdtPlanjFincr_hInclReg DATETIME,
        @tPssoaDepdtPlanjFincr_hUltAltReg DATETIME,
        @tAgteMercdDepdtPlanjFincr_json NVARCHAR(MAX)


-- ****************************************************************************
-- Criação do cursor para alimentar a tabela temporária com
-- os dados dos dependentes e seus agentes de mercado.
-- ****************************************************************************

DECLARE  CURSOR_DEPENDENTES CURSOR FOR select * from dbo.getAllDependentes() ORDER BY tPssoaDepdtPlanjFincr_nPssoaPlanjFincr;

OPEN CURSOR_DEPENDENTES
    FETCH NEXT FROM CURSOR_DEPENDENTES INTO @tPssoaDepdtPlanjFincr_nPssoaDepdtPlanjFincr,
        @tPssoaDepdtPlanjFincr_nPssoaPlanjFincr,
        @tPssoaDepdtPlanjFincr_cCategVnclo,
        @tPssoaDepdtPlanjFincr_cTpoVnclo,
        @tPssoaDepdtPlanjFincr_cIndcdDepdcPssoa,
        @tPssoaDepdtPlanjFincr_cCpfDepdtPssoaPlanjFincr,
        @tPssoaDepdtPlanjFincr_cCtrlCpfDepdtPssoaPlanjFincr,
        @tPssoaDepdtPlanjFincr_dNascDepdtPssoaPlanjFincr,
        @@tPssoaDepdtPlanjFincr_iPssoaDepdtPlanjFincr,
        @tPssoaDepdtPlanjFincr_rInfoFincrDepdt,
        @tPssoaDepdtPlanjFincr_cSitReg,
        @tPssoaDepdtPlanjFincr_cUsuarIncl,
        @tPssoaDepdtPlanjFincr_hInclReg,
        @tPssoaDepdtPlanjFincr_hUltAltReg;    

        
    WHILE @@FETCH_STATUS = 0
    BEGIN

        --Busca os agentes do dependente, e converte em formato Json para armazenar.            
        --SET @tAgteMercdDepdtPlanjFincr_json = dbo.getAgenteMercadoDadosAgenteByIdDependente(@tPssoaDepdtPlanjFincr_nPssoaDepdtPlanjFincr);

        SET @tAgteMercdDepdtPlanjFincr_json = (SELECT
                            agteMercdDepdtPlanjFincr.nPssoaDepdtPlanjFincr AS tAgteMercdDepdtPlanjFincr_nPssoaDepdtPlanjFincr,
                            agteMercdDepdtPlanjFincr.nAgteMercdPlanjFincr AS tAgteMercdDepdtPlanjFincr_nAgteMercdPlanjFincr,
                            agteMercdPlanjFincr.nAgteMercdPlanjFincr AS tAgteMercdPlanjFincr_nAgteMercdPlanjFincr,
                            agteMercdPlanjFincr.cBco AS tAgteMercdPlanjFincr_cBco,
                            agteMercdPlanjFincr.iAgteMercdPlanjFincr AS tAgteMercdPlanjFincr_iAgteMercdPlanjFincr,
                            agteMercdPlanjFincr.cUsuarIncl AS tAgteMercdPlanjFincr_cUsuarIncl,
                            agteMercdPlanjFincr.hInclReg AS tAgteMercdPlanjFincr_hInclReg
                        FROM [dbo].[tAgteMercdDepdtPlanjFincr] AS agteMercdDepdtPlanjFincr
                        INNER JOIN [dbo].[tAgteMercdPlanjFincr] AS agteMercdPlanjFincr
                            ON agteMercdDepdtPlanjFincr.nAgteMercdPlanjFincr = agteMercdPlanjFincr.nAgteMercdPlanjFincr
                        WHERE agteMercdDepdtPlanjFincr.nPssoaDepdtPlanjFincr = @tPssoaDepdtPlanjFincr_nPssoaDepdtPlanjFincr
                        FOR JSON PATH);

        INSERT INTO @DEPENDENTE_TABLE  (
            tPssoaDepdtPlanjFincr_nPssoaDepdtPlanjFincr,
            tPssoaDepdtPlanjFincr_nPssoaPlanjFincr,
            tPssoaDepdtPlanjFincr_cCategVnclo,
            tPssoaDepdtPlanjFincr_cTpoVnclo,
            tPssoaDepdtPlanjFincr_cIndcdDepdcPssoa,
            tPssoaDepdtPlanjFincr_cCpfDepdtPssoaPlanjFincr,
            tPssoaDepdtPlanjFincr_cCtrlCpfDepdtPssoaPlanjFincr,
            tPssoaDepdtPlanjFincr_dNascDepdtPssoaPlanjFincr,
            tPssoaDepdtPlanjFincr_iPssoaDepdtPlanjFincr,
            tPssoaDepdtPlanjFincr_rInfoFincrDepdt,
            tPssoaDepdtPlanjFincr_cSitReg,
            tPssoaDepdtPlanjFincr_cUsuarIncl,
            tPssoaDepdtPlanjFincr_hInclReg,
            tPssoaDepdtPlanjFincr_hUltAltReg,
            tAgteMercdDepdtPlanjFincr_json) 
            VALUES 
            (@tPssoaDepdtPlanjFincr_nPssoaDepdtPlanjFincr,
            @tPssoaDepdtPlanjFincr_nPssoaPlanjFincr,
            @tPssoaDepdtPlanjFincr_cCategVnclo,
            @tPssoaDepdtPlanjFincr_cTpoVnclo,
            @tPssoaDepdtPlanjFincr_cIndcdDepdcPssoa,
            @tPssoaDepdtPlanjFincr_cCpfDepdtPssoaPlanjFincr,
            @tPssoaDepdtPlanjFincr_cCtrlCpfDepdtPssoaPlanjFincr,
            @tPssoaDepdtPlanjFincr_dNascDepdtPssoaPlanjFincr,
            @@tPssoaDepdtPlanjFincr_iPssoaDepdtPlanjFincr,
            @tPssoaDepdtPlanjFincr_rInfoFincrDepdt,
            @tPssoaDepdtPlanjFincr_cSitReg,
            @tPssoaDepdtPlanjFincr_cUsuarIncl,
            @tPssoaDepdtPlanjFincr_hInclReg,
            @tPssoaDepdtPlanjFincr_hUltAltReg,
            @tAgteMercdDepdtPlanjFincr_json);

        FETCH NEXT FROM CURSOR_DEPENDENTES INTO @tPssoaDepdtPlanjFincr_nPssoaDepdtPlanjFincr,
            @tPssoaDepdtPlanjFincr_nPssoaPlanjFincr,
            @tPssoaDepdtPlanjFincr_cCategVnclo,
            @tPssoaDepdtPlanjFincr_cTpoVnclo,
            @tPssoaDepdtPlanjFincr_cIndcdDepdcPssoa,
            @tPssoaDepdtPlanjFincr_cCpfDepdtPssoaPlanjFincr,
            @tPssoaDepdtPlanjFincr_cCtrlCpfDepdtPssoaPlanjFincr,
            @tPssoaDepdtPlanjFincr_dNascDepdtPssoaPlanjFincr,
            @@tPssoaDepdtPlanjFincr_iPssoaDepdtPlanjFincr,
            @tPssoaDepdtPlanjFincr_rInfoFincrDepdt,
            @tPssoaDepdtPlanjFincr_cSitReg,
            @tPssoaDepdtPlanjFincr_cUsuarIncl,
            @tPssoaDepdtPlanjFincr_hInclReg,
            @tPssoaDepdtPlanjFincr_hUltAltReg;
            
    END;

CLOSE CURSOR_DEPENDENTES  
DEALLOCATE CURSOR_DEPENDENTES

--SELECT * FROM @DEPENDENTE_TABLE;
