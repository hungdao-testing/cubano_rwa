package com.rwa.data.fixture;

import java.util.List;


public class SeedDataFixture {
    private List<User> users;
    private List<Contacts> contacts;
    private List<BankAccount> bankAccounts;
    private List<Transaction> transactions;
    private List<Like> likes;
    private List<Comment> comments;
    private List<Notification> notifications;
    private List<BankTransfer> bankTransfers;


    @Override
    public String toString() {
        return "SeedDataFixture{" +
                "users=" + users +
                ", contacts=" + contacts +
                ", bankAccounts=" + bankAccounts +
                ", transactions=" + transactions +
                ", likes=" + likes +
                ", comments=" + comments +
                ", notifications=" + notifications +
                ", bankTransfers=" + bankTransfers +
                '}';
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<BankTransfer> getBankTransfers() {
        return bankTransfers;
    }

    public void setBankTransfers(List<BankTransfer> bankTransfers) {
        this.bankTransfers = bankTransfers;
    }
}
