IF OBJECT_ID('getComentarioExecutor', 'IF') IS NOT NULL
BEGIN
    DROP FUNCTION [dbo].[getComentarioExecutor]
END
GO

CREATE FUNCTION [dbo].[getComentarioExecutor]()
RETURNS TABLE
AS
RETURN
   SELECT
        [tExectPlanjFincr].[nExectPlanjFincr] AS tExectPlanjFincr_nExectPlanjFincr,
        [tExectPlanjFincr].[cExectPlanjFincr] AS tExectPlanjFincr_cExectPlanjFincr,
        [tExectPlanjFincr].[iCargoSap] AS tExectPlanjFincr_iCargoSap,
        [tExectPlanjFincr].[iExectPlanjFincr] AS tExectPlanjFincr_iExectPlanjFincr,
        [tExectPlanjFincr].[eEmailExectPlanjFincr] AS tExectPlanjFincr_eEmailExectPlanjFincr,
        [tExectPlanjFincr].[cDeptoExectFuncl] AS tExectPlanjFincr_cDeptoExectFuncl,
        [tExectPlanjFincr].[iDeptoExectFuncl] AS tExectPlanjFincr_iDeptoExectFuncl,
        [tExectPlanjFincr].[cDeptoExectAloc] AS tExectPlanjFincr_cDeptoExectAloc,
        [tExectPlanjFincr].[iDeptoExectAloc] AS tExectPlanjFincr_iDeptoExectAloc,
        [tExectPlanjFincr].[cSitReg] AS tExectPlanjFincr_cSitReg,
        [tExectPlanjFincr].[hInclReg] AS tExectPlanjFincr_hInclReg,
        [tComenPlanjFincr].[nComenPlanjFincr] AS tComenPlanjFincr_nComenPlanjFincr,
        [tComenPlanjFincr].[nPssoaPlanjFincr] AS tComenPlanjFincr_nPssoaPlanjFincr,
        [tComenPlanjFincr].[nAssntPlanjFincr] AS tComenPlanjFincr_nAssntPlanjFincr,
        [tComenPlanjFincr].[nExectPlanjFincr] AS tComenPlanjFincr_nExectPlanjFincr,
        [tComenPlanjFincr].[rComenPlanjFincr] AS tComenPlanjFincr_rComenPlanjFincr,
        [tComenPlanjFincr].[cSitReg] AS tComenPlanjFincr_cSitReg,
        [tComenPlanjFincr].[cUsuarIncl] AS tComenPlanjFincr_cUsuarIncl,
        [tComenPlanjFincr].[hInclReg] AS tComenPlanjFincr_hInclReg,
        [tComenPlanjFincr].[hUltAltReg] AS tComenPlanjFincr_hUltAltReg
    FROM [PFIND000].[dbo].[tExectPlanjFincr] as tExectPlanjFincr
    INNER JOIN [PFIND000].[dbo].[tComenPlanjFincr] AS tComenPlanjFincr
        ON tExectPlanjFincr.nExectPlanjFincr = tComenPlanjFincr.nExectPlanjFincr;
GO

--Precisa pegar o CTE do Step D e agregar a function acima


