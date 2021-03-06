package com.bootcamp.mavenapp.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.mavenapp.dao.AccountDao;
import com.bootcamp.mavenapp.dao.repository.AccountRepository;
import com.bootcamp.mavenapp.model.Account;

public class AccountDaoImpl extends BaseImpl implements AccountDao {

	@Autowired
	private AccountRepository repository;
	
	@Override
	public Account getById(int account_id) throws Exception {
		return repository.findByAccountNumber(account_id);
	}

	@Override
	public Account save(Account account) throws Exception {
		// TODO Auto-generated method stub
		return repository.save(account);
	}

	@Override
	public void delete(Account account) throws Exception {
		repository.delete(account);
		
	}

	@Override
	public List<Account> getList() throws Exception {
		// TODO Auto-generated method stub
		CriteriaBuilder critB = em.getCriteriaBuilder();
		CriteriaQuery<Account> query = critB.createQuery(Account.class);
		Root<Account> root = query.from(Account.class);
		query.select(root);
		
		TypedQuery<Account> q = em.createQuery(query);
		
		return q.getResultList();
	}

}
