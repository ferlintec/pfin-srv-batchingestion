WITH sp2_tAnmalPssoaPlanjFincr_tEspceAnmalPlanjFincr_CTE
    (
         tAnmalPssoaPlanjFincr_nAnmalPssoaPlanjFincr
        ,tAnmalPssoaPlanjFincr_nPssoaPlanjFincr
        ,tAnmalPssoaPlanjFincr_iAnmalPssoaPlanjFincr
        ,tAnmalPssoaPlanjFincr_nEspceAnmalPlanjFincr
        ,tAnmalPssoaPlanjFincr_cSitReg
        ,tAnmalPssoaPlanjFincr_cUsuarIncl
        ,tAnmalPssoaPlanjFincr_hInclReg
        ,tAnmalPssoaPlanjFincr_hUltAltReg
        ,nEspceAnmalPlanjFincr_nEspceAnmalPlanjFincr
        ,nEspceAnmalPlanjFincr_rEspceAnmalPlanjFincr
      )
    AS
    (
        SELECT tA.[nAnmalPssoaPlanjFincr]
            ,tA.[nPssoaPlanjFincr]
            ,tA.[iAnmalPssoaPlanjFincr]
            ,tA.[nEspceAnmalPlanjFincr]
            ,tA.[cSitReg]
            ,tA.[cUsuarIncl]
            ,tA.[hInclReg]
            ,tA.[hUltAltReg]
            ,tB.[nEspceAnmalPlanjFincr]
            ,tB.[rEspceAnmalPlanjFincr]
        FROM [PFIND000].[dbo].[tAnmalPssoaPlanjFincr] as tA
            INNER JOIN [tEspceAnmalPlanjFincr] as tB ON tA.[nEspceAnmalPlanjFincr] = tB.[nEspceAnmalPlanjFincr]
        ORDER BY tA.[nPssoaPlanjFincr]
    )

    SELECT tAnmalPssoaPlanjFincr_nAnmalPssoaPlanjFincr
        ,tAnmalPssoaPlanjFincr_nPssoaPlanjFincr
        ,tAnmalPssoaPlanjFincr_iAnmalPssoaPlanjFincr
        ,tAnmalPssoaPlanjFincr_nEspceAnmalPlanjFincr
        ,tAnmalPssoaPlanjFincr_cSitReg
        ,tAnmalPssoaPlanjFincr_cUsuarIncl
        ,tAnmalPssoaPlanjFincr_hInclReg
        ,tAnmalPssoaPlanjFincr_hUltAltReg
        ,nEspceAnmalPlanjFincr_nEspceAnmalPlanjFincr
        ,nEspceAnmalPlanjFincr_rEspceAnmalPlanjFincr      
    FROM sp2_tAnmalPssoaPlanjFincr_tEspceAnmalPlanjFincr_CTE




    
   