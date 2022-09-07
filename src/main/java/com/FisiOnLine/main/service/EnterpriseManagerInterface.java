package com.FisiOnLine.main.service;

import com.FisiOnLine.main.model.Enterprise;

import java.util.List;

public interface EnterpriseManagerInterface {
    public List<Enterprise> getEnterpriseX();
    public Enterprise getOnlyEnterprise(Long idEnterprise) throws Exception;
    public String setCreateEnterprise(Enterprise EnterpriseX) throws Exception;
    public Enterprise UpdateEnterpriseAll(Enterprise EnterpriseX) throws Exception;
    public String DeleteEnterprise(Long  idEnterprise) throws Exception;
}
