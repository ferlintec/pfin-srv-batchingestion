IF OBJECT_ID('getAssuntoMomentoVida', 'IF') IS NOT NULL
BEGIN
    DROP FUNCTION [dbo].[getAssuntoMomentoVida]
END
GO

CREATE FUNCTION [dbo].[getAssuntoMomentoVida]()
RETURNS TABLE
AS
RETURN
    SELECT
        [tAssntPlanjFincr].[nAssntPlanjFincr] as tAssntPlanjFincr_nAssntPlanjFincr,
        [tAssntPlanjFincr].[nMomenVidaPlanjFincr] as tAssntPlanjFincr_nMomenVidaPlanjFincr,
        [tAssntPlanjFincr].[nOrdExibcInfoPlanjFincr] as tAssntPlanjFincr_nOrdExibcInfoPlanjFincr,
        [tAssntPlanjFincr].[rAssntPlanjFincr] as tAssntPlanjFincr_rAssntPlanjFincr,
        [tMomenVidaPlanjFincr].[nMomenVidaPlanjFincr] as tMomenVidaPlanjFincr_nMomenVidaPlanjFincr,
        [tMomenVidaPlanjFincr].[nOrdExibcInfoPlanjFincr] as tMomenVidaPlanjFincr_nOrdExibcInfoPlanjFincr,
        [tMomenVidaPlanjFincr].[rMomenVidaPlanjFincr] as tMomenVidaPlanjFincr_rMomenVidaPlanjFincr
    FROM [PFIND000].[dbo].[tAssntPlanjFincr] as tAssntPlanjFincr
    INNER JOIN [PFIND000].[dbo].[tMomenVidaPlanjFincr] as tMomenVidaPlanjFincr
        ON tMomenVidaPlanjFincr.nMomenVidaPlanjFincr = tAssntPlanjFincr.nMomenVidaPlanjFincr
    ORDER BY [tAssntPlanjFincr].[nAssntPlanjFincr];
GO



--Precisa pegar o CTE do Step C e agregar a function acima


