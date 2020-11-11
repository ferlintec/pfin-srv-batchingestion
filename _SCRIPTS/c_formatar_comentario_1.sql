IF OBJECT_ID('getInfoComplTipoInfoComplementar', 'IF') IS NOT NULL
BEGIN
    DROP FUNCTION [dbo].[getInfoComplTipoInfoComplementar]
END
GO

CREATE FUNCTION [dbo].[getInfoComplTipoInfoComplementar]()
RETURNS TABLE
AS
RETURN
    SELECT
        [infoComplPlanjFincr].[nInfoComplPlanjFincr] as infoComplPlanjFincr_nInfoComplPlanjFincr,
        [infoComplPlanjFincr].[rInfoComplPlanjFincr] as infoComplPlanjFincr_rInfoComplPlanjFincr,
        [infoComplPlanjFincr].[rTitloInfoCompl] as infoComplPlanjFincr_rTitloInfoCompl,
        [infoComplPlanjFincr].[eLinkInfoCompl] as infoComplPlanjFincr_eLinkInfoCompl,
        [infoComplPlanjFincr].[iLinkInfoCompl] as infoComplPlanjFincr_iLinkInfoCompl,
        [infoComplPlanjFincr].[nTpoInfoCompl] as infoComplPlanjFincr_nTpoInfoCompl,
        [tpoInfoComplPlanjFincr].[nTpoInfoCompl] as tpoInfoComplPlanjFincr_nTpoInfoCompl,
        [tpoInfoComplPlanjFincr].[iTpoInfoCompl] as tpoInfoComplPlanjFincr_iTpoInfoCompl
    FROM [PFIND000].[dbo].[tInfoComplPlanjFincr] as infoComplPlanjFincr
    INNER JOIN [PFIND000].[dbo].[tTpoInfoComplPlanjFincr] as tpoInfoComplPlanjFincr
    ON infoComplPlanjFincr.nTpoInfoCompl = tpoInfoComplPlanjFincr.nTpoInfoCompl
    ORDER BY infoComplPlanjFincr.nInfoComplPlanjFincr;
GO


--Precisa fazer o cursor e juntar com a function acima
SELECT
    [assntInfoPlanjFincr].[nAssntPlanjFincr] as assntInfoPlanjFincr_nAssntPlanjFincr,
    [assntInfoPlanjFincr].[nInfoComplPlanjFincr] as assntInfoPlanjFincr_nInfoComplPlanjFincr
FROM [PFIND000].[dbo].[tAssntInfoPlanjFincr] AS assntInfoPlanjFincr;

select * from [dbo].[getInfoComplTipoInfoComplementar]();