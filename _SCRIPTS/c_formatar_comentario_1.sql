-- *******************************************************************************
-- Recupera as informações complementares de Assunto
-- Página 3 do fluxo.
-- *******************************************************************************

IF OBJECT_ID('getAssuntoInfoComplTipoInfoComplementar', 'IF') IS NOT NULL
BEGIN
    DROP FUNCTION [dbo].[getAssuntoInfoComplTipoInfoComplementar]
END
GO

CREATE FUNCTION [dbo].[getAssuntoInfoComplTipoInfoComplementar]()
RETURNS TABLE
AS
RETURN
    SELECT
        [assntInfoPlanjFincr].[nAssntPlanjFincr] as assntInfoPlanjFincr_nAssntPlanjFincr,
        [assntInfoPlanjFincr].[nInfoComplPlanjFincr] as assntInfoPlanjFincr_nInfoComplPlanjFincr,
        [infoComplPlanjFincr].[nInfoComplPlanjFincr] as infoComplPlanjFincr_nInfoComplPlanjFincr,
        [infoComplPlanjFincr].[rInfoComplPlanjFincr] as infoComplPlanjFincr_rInfoComplPlanjFincr,
        [infoComplPlanjFincr].[rTitloInfoCompl] as infoComplPlanjFincr_rTitloInfoCompl,
        [infoComplPlanjFincr].[eLinkInfoCompl] as infoComplPlanjFincr_eLinkInfoCompl,
        [infoComplPlanjFincr].[iLinkInfoCompl] as infoComplPlanjFincr_iLinkInfoCompl,
        [infoComplPlanjFincr].[nTpoInfoCompl] as infoComplPlanjFincr_nTpoInfoCompl,
        [tpoInfoComplPlanjFincr].[nTpoInfoCompl] as tpoInfoComplPlanjFincr_nTpoInfoCompl,
        [tpoInfoComplPlanjFincr].[iTpoInfoCompl] as tpoInfoComplPlanjFincr_iTpoInfoCompl
        

    FROM [PFIND000].[dbo].[tAssntInfoPlanjFincr] AS assntInfoPlanjFincr
        INNER JOIN [PFIND000].[dbo].[tInfoComplPlanjFincr] as infoComplPlanjFincr 
            ON infoComplPlanjFincr.nInfoComplPlanjFincr = assntInfoPlanjFincr.nAssntPlanjFincr
        INNER JOIN [PFIND000].[dbo].[tTpoInfoComplPlanjFincr] as tpoInfoComplPlanjFincr
            ON infoComplPlanjFincr.nTpoInfoCompl = tpoInfoComplPlanjFincr.nTpoInfoCompl;
GO

--select * from [dbo].[getAssuntoInfoComplTipoInfoComplementar]() ORDER BY assntInfoPlanjFincr_nAssntPlanjFincr, infoComplPlanjFincr_nInfoComplPlanjFincr