select * from dbo.tAgteMercdDepdtPlanjFincr as agenteMercadoDependente
    inner join dbo.tAgteMercdPlanjFincr as agenteMercadoPlanFinanc
    on agenteMercadoDependente.nAgteMercdPlanjFincr = agenteMercadoPlanFinanc.nAgteMercdPlanjFincr
    order by nPssoaDepdtPlanjFincr;