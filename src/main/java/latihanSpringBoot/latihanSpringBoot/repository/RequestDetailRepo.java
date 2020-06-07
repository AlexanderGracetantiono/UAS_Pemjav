///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.springboot.HRISNEW.repositories;
//
//import com.springboot.HRISNEW.entities.RequestDetail;
//import java.util.List;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
///**
// *
// * @author HARRY-PC
// */
//@Repository
//public interface RequestDetailRepo extends CrudRepository<RequestDetail, Integer>{
//    
//    @Query(value = "SELECT * FROM request_detail WHERE id=?1", nativeQuery = true)
//    public RequestDetail requestEmpid(String id);
//    
//    @Query(value = "SELECT * FROM request_detail WHERE nik=?1 AND request_status NOT IN('Resubmit','Rejected') AND isdelete  NOT IN (1)", nativeQuery = true)
//    public List<RequestDetail> usedRequest(Integer id);
//    
//    @Query(value = "SELECT COUNT(id) FROM request_detail WHERE nik = ?1", nativeQuery = true)
//    public Integer jumlahId(Integer id);
//    
//    @Query(value = "SELECT * FROM request_detail WHERE (direct_report = ?1 OR next_role = ?2) "
//            + "AND isdelete = 0 AND request_status = 'NotYet'", nativeQuery = true)
//    public List<RequestDetail> findListLeaveRequest(Integer nikDirect, Integer nikNext);
//}
