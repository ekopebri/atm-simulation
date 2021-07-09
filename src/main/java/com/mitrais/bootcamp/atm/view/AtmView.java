package com.mitrais.bootcamp.atm.view;

import com.mitrais.bootcamp.atm.entity.Account;
import com.mitrais.bootcamp.atm.model.TransferRequest;
import com.mitrais.bootcamp.atm.model.TransferResponse;
import com.mitrais.bootcamp.atm.model.WithdrawResponse;
import com.mitrais.bootcamp.atm.service.AccountService;
import com.mitrais.bootcamp.atm.util.InputUtil;
import com.mitrais.bootcamp.atm.util.StringUtil;
import com.mitrais.bootcamp.atm.util.ValidationUtil;

public class AtmView {
    private AccountService accountService;

    public AtmView(AccountService accountService) {
        this.accountService = accountService;
    }

    public void showAtm() {
        accountService.initialData();

        while (true) {
            String accountNumber = InputUtil.inputString("Enter Account Number");
            String pin = InputUtil.inputString("Enter PIN");

            if (ValidationUtil.checkAccount(accountNumber, pin)) {
                Account account = accountService.getAccount(accountNumber, pin);
                if (account != null) {
                    showTransactionScreen(account.getAccountNumber());
                } else {
                    System.out.println("Invalid Account Number/PIN");
                }
            }
        }
    }

    public void showTransactionScreen(String accountNumber) {
        System.out.println("1. Withdraw");
        System.out.println("2. Fund Transfer");
        System.out.println("3. Exit");
        String transactionInput = InputUtil.inputString("Please choose option[3]");
        switch (transactionInput.trim()) {
            case "":
            case "3":
                //
                break;
            case "1":
                showWithDrawScreen(accountNumber);
                break;
            case "2":
                showFundTransferScreen(new TransferRequest(accountNumber, "", 0L, ""), 0L);
                break;
            default:
                showTransactionScreen(accountNumber);
                break;
        }
    }

    public void showWithDrawScreen(String accountNumber) {
        System.out.println("1. $10");
        System.out.println("2. $50");
        System.out.println("3. $100");
        System.out.println("4. Other");
        System.out.println("5. Back");

        String transactionInput = InputUtil.inputString("Please choose option[5]");

        if (transactionInput.trim().equals("") || transactionInput.trim().equals("5")) {

        } else if (transactionInput.trim().equals("1") || transactionInput.trim().equals("2") || transactionInput.trim().equals("3")) {
            WithdrawResponse response = accountService.withdrawBalance(transactionInput.trim(), accountNumber, 0L);
            if (response.isSuccess()) {
                showSummaryScreen(response);
            } else {
                showWithDrawScreen(response.getAccountNumber());
            }
        } else if (transactionInput.trim().equals("4")) {
            showOtherWithdrawScreen(accountNumber);
        } else {
            showWithDrawScreen(accountNumber);
        }
    }

    private void showSummaryScreen(WithdrawResponse response) {

        System.out.println("Summary");
        System.out.println("Date : " + response.getDate());
        System.out.println("Withdraw : " + response.getWithdraw());
        System.out.println("Balance : " + response.getBalance());
        System.out.println();
        System.out.println("1. Transaction");
        System.out.println("2. Exit");

        String transactionInput = InputUtil.inputString("Please choose option[2]");
        if (transactionInput.trim().equals("") || transactionInput.trim().equals("2")) {
            showAtm();
        } else {
            showTransactionScreen(response.getAccountNumber());
        }
    }

    private void showOtherWithdrawScreen(String accountNumber) {
        System.out.println("Other Withdraw");
        String transactionInput = InputUtil.inputString("Enter amount to withdraw");

        if (ValidationUtil.checkInput(transactionInput.trim())) {
            WithdrawResponse response = accountService.withdrawBalance(transactionInput.trim(), accountNumber, Long.parseLong(transactionInput));
            if (response.isSuccess()) {
                showSummaryScreen(response);
            } else {
                showWithDrawScreen(response.getAccountNumber());
            }
        }
    }

    public void showFundTransferScreen(TransferRequest request, Long typeScreen) {
        if (typeScreen == 0) {
            System.out.println("Please enter destination account and press enter to continue or");
            String input = InputUtil.inputString("press enter to go back to Transaction");
            if (input.trim().equals("")) {
                showTransactionScreen(request.getFrom());
            } else if (ValidationUtil.isAccountCorrect(input.trim()) && !input.trim().equals(request.getFrom())) {
                if (accountService.isAccountExist(input)) {
                    request.setTo(input);
                    showFundTransferScreen(request, 1L);
                } else {
                    System.out.println("Invalid account");
                    showTransactionScreen(request.getFrom());
                }
            }
        } else if (typeScreen == 1) {
            System.out.println("Please enter transfer amount and");
            System.out.println("press enter to continue or");
            String input = InputUtil.inputString("press enter to go back to Transaction");
            if (input.trim().equals("")) {
                showTransactionScreen(request.getFrom());
            } else if (ValidationUtil.isAmountCorrect(input)) {
                request.setAmount(Long.parseLong(input));
                showFundTransferScreen(request, 2L);
            }
        } else if (typeScreen == 2) {
            System.out.println("Reference Number: (This is an autogenerated random 6 digits number)");
            InputUtil.inputString("press enter to continue");
            request.setReferenceNumber(StringUtil.generateRandomNumber());
            showFundTransferScreen(request, 3L);
        } else if (typeScreen == 3) {
            System.out.println("Transfer Confirmation");
            System.out.println("Destination Account : " + request.getTo());
            System.out.println("Transfer Amount : $" + request.getAmount());
            System.out.println("Reference Number : " + request.getReferenceNumber());
            System.out.println();
            System.out.println("1. Confirm Trx");
            System.out.println("2. Cancel Trx");
            String transactionInput = InputUtil.inputString("Choose option[2]");

            if (transactionInput.equals("1")) {
                TransferResponse response = accountService.transferFunds(request);
                if (response.isSuccess()) {
                    showFundTransferSummaryScreen(response);
                } else {
                    showTransactionScreen(response.getFrom());
                }
            } else {
                showTransactionScreen(request.getFrom());
            }
        } else {
            showFundTransferScreen(request, 0L);
        }
    }

    private void showFundTransferSummaryScreen(TransferResponse response) {
        System.out.println("Fund Transfer Summary");
        System.out.println("Destination Account : " + response.getTo());
        System.out.println("Transfer Amount : " + response.getAmount());
        System.out.println("Reference Number : " + response.getReferenceNumber());
        System.out.println("Balance : " + response.getBalance());
        System.out.println();
        System.out.println("1. Transaction");
        System.out.println("2. Exit");

        String transactionInput = InputUtil.inputString("Choose option[2]");
        if (transactionInput.trim().equals("1")) {
            showTransactionScreen(response.getFrom());
        } else {
            showAtm();
        }
    }
}
