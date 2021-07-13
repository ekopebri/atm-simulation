package com.mitrais.bootcamp.atm;

import com.mitrais.bootcamp.atm.repository.AccountRepository;
import com.mitrais.bootcamp.atm.repository.AccountRepositoryImpl;
import com.mitrais.bootcamp.atm.service.AccountService;
import com.mitrais.bootcamp.atm.service.AccountServiceImpl;
import com.mitrais.bootcamp.atm.view.AtmView;

/**
 * Hello world!
 *
 */
public class AtmApp
{
    public static void main( String[] args )
    {
        AccountRepository accountRepository = new AccountRepositoryImpl();
        AccountService accountService = new AccountServiceImpl(accountRepository);
        accountService.initialData();
        AtmView atmView = new AtmView(accountService);
        atmView.showAtm();
    }
}
