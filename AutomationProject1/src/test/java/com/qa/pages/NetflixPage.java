package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NetflixPage {
WebDriver driver;
	
	public NetflixPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='id_userLoginId']")
	WebElement EmailIdTextFeild;
	public WebElement getEmailIdTextFeild() {
		return EmailIdTextFeild;
	}
	
	@FindBy(xpath="//input[@id='id_password']")
	WebElement PasswordTextFeild;
	public WebElement getPasswordTextFeild() {
		return PasswordTextFeild;
	}
	
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	WebElement SignInBtn;
	public WebElement getSignInBtn() {
		return SignInBtn;
	}
	
	@FindBy(xpath="//body/div[@id='appMountPoint']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/a[1]/div[1]/div[1]")
	WebElement ProfileBtn;
	public WebElement getProfileBtn() {
		return ProfileBtn;
	}
	
	@FindBy(xpath="//body/div[@id='appMountPoint']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")
	WebElement SearchBtn;
	public WebElement getSearchBtn() {
		return SearchBtn;
	}
	
	@FindBy(name="searchInput")
	WebElement SearchBox;
	public WebElement getSearchBox() {
		return SearchBox;
	}
	
	@FindAll(@FindBy(css = "div[id^='title-card-']"))
	List<WebElement> SelectMovie;
	public List<WebElement> getSelectMovie() {
		return SelectMovie;
	}
	
	@FindBy(css = "div.netflix-sans-font-loaded div.focus-trap-wrapper.previewModal--wrapper.detail-modal.has-smaller-buttons:nth-child(2) div.previewModal--container.detail-modal.has-smaller-buttons div.previewModal--player_container.detail-modal.has-smaller-buttons div.previewModal--player-titleTreatmentWrapper div.previewModal--player-titleTreatment-left.previewModal--player-titleTreatment.detail-modal.has-smaller-buttons.detail-modal.has-smaller-buttons div.buttonControls--container:nth-child(3) div.ltr-79elbk:nth-child(2) div.ptrack-content > button.color-supplementary.hasIcon.ltr-pjs1vp")
	WebElement AddtoList;
	public WebElement getAddtoList() {
		return AddtoList;
	}
	
	@FindBy(css = "div.netflix-sans-font-loaded div:nth-child(1) div:nth-child(1) div.focus-trap-wrapper.previewModal--wrapper.detail-modal.has-smaller-buttons:nth-child(2) div.previewModal--container.detail-modal.has-smaller-buttons > div.previewModal-close")
	WebElement CloseBtn;
	public WebElement getCloseBtn() {
		return CloseBtn;
	}
	
	@FindBy(linkText ="Home")
	WebElement home;
	public WebElement gethome() {
		return home;
	}
	@FindBy(linkText ="My List")
	WebElement list;
	public WebElement getlist() {
		return list;
	}
}
