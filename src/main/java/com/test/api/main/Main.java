package com.test.api.main;

import com.test.api.AcceptMaxBid;
import com.test.api.ContactUs;
import com.test.api.CreateAuction;
import com.test.api.CreateBid;
import com.test.api.CreateComment;
import com.test.api.CreateItem;
import com.test.api.DeleteComment;
import com.test.api.EditAccount;
import com.test.api.EditAuction;
import com.test.api.GetDetailAuction;
import com.test.api.GetListAuctions;
import com.test.api.GetListAuctionsByStatus;
import com.test.api.GetListAuctionsByType;
import com.test.api.GetListAuctionsByUser;
import com.test.api.GetListBids;
import com.test.api.GetListBrands;
import com.test.api.GetListCategories;
import com.test.api.GetListComment;
import com.test.api.GetListLikes;
import com.test.api.GetNews;
import com.test.api.GetNotifications;
import com.test.api.GetSlider;
import com.test.api.LikeAuction;
import com.test.api.Login;
import com.test.api.Logout;
import com.test.api.ReadNew;
import com.test.api.ReadNotification;
import com.test.api.Search;
import com.test.api.SignUp;
import com.test.api.TotalLikesOfAuction;
import constants.Constant;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException {
        while (true) {
            printMenu();
            int option = inputOption();
            switch (option) {
                case 1:
                    configBaseUrl();
                    printDivide();
                    break;
                case 2:
                    showListAPIs();
                    printDivide();
                    break;
                case 3:
                    runAllOrEachAPI();
                    printDivide();
                    break;
                default:
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("==============MENU==============");
        System.out.println("1) Chọn lựa đường link base URL (Default: https://auctions-app-2.herokuapp.com/api)");
        System.out.println("2) Chọn lựa API cần kiểm thử tự động");
        System.out.println("3) Chạy từng unit test case hay tất cả unit test của một API");
        System.out.println("Please choose number on menu: ");
    }

    public static int inputOption() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void configBaseUrl() {
        System.out.println("1) https://auctions-app-2.herokuapp.com/api");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input == null || input.equals("")) {
            System.out.println("Use default URL: https://auctions-app-2.herokuapp.com/api");
        } else {
            System.out.println("Use URL 1: https://auctions-app-2.herokuapp.com/api");
        }
    }

    public static void showListAPIs() {
        System.out.println("List APIs: ");
        System.out.println("1) " + Constant.LOG_IN);
        System.out.println("2) " + Constant.SIGN_UP);
        System.out.println("3) " + Constant.EDIT_ACCOUNT);
        System.out.println("4) " + Constant.LOGOUT);
        System.out.println("5) " + Constant.GET_LIST_AUCTIONS);
        System.out.println("6) " + Constant.GET_LIST_AUCTIONS_BY_STATUS);
        System.out.println("7) " + Constant.GET_LIST_AUCTIONS_BY_USER);
        System.out.println("8) " + Constant.GET_LIST_AUCTIONS_BY_TYPE);
        System.out.println("9) " + Constant.GET_DETAIL_AUCTION);
        System.out.println("10) " + Constant.CREATE_AUCTION);
        System.out.println("11) " + Constant.EDIT_AUCTION);
        System.out.println("12) " + Constant.CREATE_ITEM);
        System.out.println("13) " + Constant.CREATE_COMMENT);
        System.out.println("14) " + Constant.GET_LIST_COMMENT);
        System.out.println("15) " + Constant.CREATE_BID);
        System.out.println("16) " + Constant.GET_LIST_BIDS);
        System.out.println("17) " + Constant.GET_LIST_CATEGORIES);
        System.out.println("18) " + Constant.GET_LIST_BRANDS);
        System.out.println("19) " + Constant.ACCEPT_MAX_BID);
        System.out.println("20) " + Constant.CONTACT_US);
        System.out.println("21) " + Constant.LIKE_AUCTION);
        System.out.println("22) " + Constant.GET_LIST_LIKE);
        System.out.println("23) " + Constant.TOTAL_LIKES_OF_AUCTION);
        System.out.println("24) " + Constant.GET_NEWS);
        System.out.println("25) " + Constant.READ_NEWS);
        System.out.println("26) " + Constant.GET_NOTIFICATIONS);
        System.out.println("27) " + Constant.READ_NOTIFICATION);
        System.out.println("28) " + Constant.GET_SLIDER);
        System.out.println("29) " + Constant.SEARCH);
        System.out.println("30) " + Constant.DELETE_COMMENT);
    }

    public static void runAllOrEachAPI() throws IOException, NoSuchMethodException {
        System.out.println("1) Run each unit test case");
        System.out.println("2) Run all unit test case");
        System.out.println("Please input your option: ");
        int option = inputOption();
        showListAPIs();
        System.out.println("Please input number of APIs to run unit test case: ");
        int numberOfAPI = inputOption();
        if (option == 1) {
            System.out.println("List unit test case: ");
        }
        switch (numberOfAPI) {
            case 1:
                if (option == 1) {
                    System.out.println("1) " + Login.class.getMethod("loginSuccessful").getName());
                    System.out.println("2) " + Login.class.getMethod("passwordIncorrect").getName());
                    printCommandInputNumberOfUC();
                    int numberOfUC = inputOption();
                    if (numberOfUC == 1) {
                        Login.loginSuccessful();
                    } else {
                        Login.passwordIncorrect();
                    }
                } else {
                    Login.loginSuccessful();
                    Login.passwordIncorrect();
                }
                break;
            case 2:
                if (option == 1) {
                    System.out.println("1) " + SignUp.class.getMethod("signUpSuccessful").getName());
                    System.out.println("2) " + SignUp.class.getMethod("missingName").getName());
                    System.out.println("3) " + SignUp.class.getMethod("passwordAndRepassNotMatch").getName());
                    printCommandInputNumberOfUC();
                    int numberOfUC = inputOption();
                    if (numberOfUC == 1) {
                        SignUp.signUpSuccessful();
                    } else if (numberOfUC == 2) {
                        SignUp.missingName();
                    } else {
                        SignUp.passwordAndRepassNotMatch();
                    }
                } else {
                    SignUp.passwordAndRepassNotMatch();
                    SignUp.missingName();
                    SignUp.signUpSuccessful();
                }
                break;
            case 3:
                if (option == 1) {
                    System.out.println("1) " + EditAccount.class.getMethod("editNameSuccessful").getName());
                    System.out.println("2) " + EditAccount.class.getMethod("missingAccessToken").getName());
                    printCommandInputNumberOfUC();
                    int numberOfUC = inputOption();
                    if (numberOfUC == 1) {
                        EditAccount.editNameSuccessful();
                    } else {
                        EditAccount.missingAccessToken();
                    }
                } else {
                    EditAccount.editNameSuccessful();
                    EditAccount.missingAccessToken();
                }
                break;
            case 4:
                if (option == 1) {
                    System.out.println("1) " + Logout.class.getMethod("logoutSuccessful").getName());
                    printCommandInputNumberOfUC();
                    inputOption();
                    Logout.logoutSuccessful();
                } else {
                    Logout.logoutSuccessful();
                }
                break;
            case 5:
                if (option == 1) {
                    System.out.println("1) " + GetListAuctions.class.getMethod("getListAuctionsSuccessful").getName());
                    printCommandInputNumberOfUC();
                    inputOption();
                    GetListAuctions.getListAuctionsSuccessful();
                } else {
                    GetListAuctions.getListAuctionsSuccessful();
                }
                break;
            case 6:
                if (option == 1) {
                    System.out.println("1) " + GetListAuctionsByStatus.class.getMethod("getListAuctionsByStatusSuccessful").getName());
                    printCommandInputNumberOfUC();
                    inputOption();
                    GetListAuctionsByStatus.getListAuctionsByStatusSuccessful();
                } else {
                    GetListAuctionsByStatus.getListAuctionsByStatusSuccessful();
                }
                break;
            case 7:
                if (option == 1) {
                    System.out.println("1) " + GetListAuctionsByUser.class.getMethod("getListAuctionsByUserSuccessful").getName());
                    printCommandInputNumberOfUC();
                    inputOption();
                    GetListAuctionsByUser.getListAuctionsByUserSuccessful();
                } else {
                    GetListAuctionsByUser.getListAuctionsByUserSuccessful();
                }
                break;
            case 8:
                if (option == 1) {
                    System.out.println("1) " + GetListAuctionsByType.class.getMethod("getListAuctionsByTypeSuccessful").getName());
                    printCommandInputNumberOfUC();
                    inputOption();
                    GetListAuctionsByType.getListAuctionsByTypeSuccessful();
                } else {
                    GetListAuctionsByType.getListAuctionsByTypeSuccessful();
                }
                break;
            case 9:
                if (option == 1) {
                    System.out.println("1) " + GetDetailAuction.class.getMethod("getDetailAuctionSuccessful").getName());
                    printCommandInputNumberOfUC();
                    inputOption();
                    GetDetailAuction.getDetailAuctionSuccessful();
                } else {
                    GetDetailAuction.getDetailAuctionSuccessful();
                }
                break;
            case 10:
                if (option == 1) {
                    System.out.println("1) " + CreateAuction.class.getMethod("createAuctionsSuccessful").getName());
                    System.out.println("2) " + CreateAuction.class.getMethod("startDateIncorrect").getName());
                    printCommandInputNumberOfUC();
                    int numberOfUC = inputOption();
                    if (numberOfUC == 1) {
                        CreateAuction.createAuctionsSuccessful();
                    } else {
                        CreateAuction.startDateIncorrect();
                    }
                } else {
                    CreateAuction.createAuctionsSuccessful();
                    CreateAuction.startDateIncorrect();
                }
                break;
            case 11:
                if (option == 1) {
                    System.out.println("1) " + EditAuction.class.getMethod("editAuctionsSuccessful").getName());
                    System.out.println("2) " + EditAuction.class.getMethod("missingCategoryId").getName());
                    printCommandInputNumberOfUC();
                    int numberOfUC = inputOption();
                    if (numberOfUC == 1) {
                        EditAuction.editAuctionsSuccessful();
                    } else {
                        EditAuction.missingCategoryId();
                    }
                } else {
                    EditAuction.editAuctionsSuccessful();
                    EditAuction.missingCategoryId();
                }
                break;
            case 12:
                if (option == 1) {
                    System.out.println("1) " + CreateItem.class.getMethod("createItemsSuccessful").getName());
                    printCommandInputNumberOfUC();
                    inputOption();
                    CreateItem.createItemsSuccessful();
                } else {
                    CreateItem.createItemsSuccessful();
                }
                break;
            case 13:
                if (option == 1) {
                    System.out.println("1) " + CreateComment.class.getMethod("createCommentSuccessful").getName());
                    printCommandInputNumberOfUC();
                    inputOption();
                    CreateComment.createCommentSuccessful();
                } else {
                    CreateComment.createCommentSuccessful();
                }
                break;
            case 14:
                if (option == 1) {
                    System.out.println("1) " + GetListComment.class.getMethod("getListCommentSuccessful").getName());
                    printCommandInputNumberOfUC();
                    inputOption();
                    GetListComment.getListCommentSuccessful();
                } else {
                    GetListComment.getListCommentSuccessful();
                }
                break;
            case 15:
                if (option == 1) {
                    System.out.println("1) " + CreateBid.class.getMethod("createBidsSuccessful").getName());
                    printCommandInputNumberOfUC();
                    inputOption();
                    CreateBid.createBidsSuccessful();
                } else {
                    CreateBid.createBidsSuccessful();
                }
                break;
            case 16:
                if (option == 1) {
                    System.out.println("1) " + GetListBids.class.getMethod("getListBidsSuccessful").getName());
                    printCommandInputNumberOfUC();
                    inputOption();
                    GetListBids.getListBidsSuccessful();
                } else {
                    GetListBids.getListBidsSuccessful();
                }
                break;
            case 17:
                if (option == 1) {
                    System.out.println("1) " + GetListCategories.class.getMethod("getListCategoriesSuccessful").getName());
                    printCommandInputNumberOfUC();
                    inputOption();
                    GetListCategories.getListCategoriesSuccessful();
                } else {
                    GetListCategories.getListCategoriesSuccessful();
                }
                break;
            case 18:
                if (option == 1) {
                    System.out.println("1) " + GetListBrands.class.getMethod("getListBrandsSuccessful").getName());
                    printCommandInputNumberOfUC();
                    inputOption();
                    GetListBrands.getListBrandsSuccessful();
                } else {
                    GetListBrands.getListBrandsSuccessful();
                }
                break;
            case 19:
                if (option == 1) {
                    System.out.println("1) " + AcceptMaxBid.class.getMethod("acceptMaxBidWhenAuctionNotFinished").getName());
                    printCommandInputNumberOfUC();
                    inputOption();
                    AcceptMaxBid.acceptMaxBidWhenAuctionNotFinished();
                } else {
                    AcceptMaxBid.acceptMaxBidWhenAuctionNotFinished();
                }
                break;
            case 20:
                if (option == 1) {
                    System.out.println("1) " + ContactUs.class.getMethod("contactUsWhenMeetErrorSystem").getName());
                    System.out.println("2) " + ContactUs.class.getMethod("contactUsWhenNotKnowUse").getName());
                    System.out.println("3) " + ContactUs.class.getMethod("contactUsWhenOther").getName());
                    printCommandInputNumberOfUC();
                    int numberOfUC = inputOption();
                    if (numberOfUC == 1) {
                        ContactUs.contactUsWhenMeetErrorSystem();
                    } else if (numberOfUC == 2) {
                        ContactUs.contactUsWhenNotKnowUse();
                    } else {
                        ContactUs.contactUsWhenOther();
                    }
                } else {
                    ContactUs.contactUsWhenMeetErrorSystem();
                    ContactUs.contactUsWhenNotKnowUse();
                    ContactUs.contactUsWhenOther();
                }
                break;
            case 21:
                if (option == 1) {
                    System.out.println("1) " + LikeAuction.class.getMethod("likeAuctionSuccessful").getName());
                    inputOption();
                    LikeAuction.likeAuctionSuccessful();
                } else {
                    LikeAuction.likeAuctionSuccessful();
                }
                break;
            case 22:
                if (option == 1) {
                    System.out.println("1) " + GetListLikes.class.getMethod("getListLikesSuccessful").getName());
                    inputOption();
                    GetListLikes.getListLikesSuccessful();
                } else {
                    GetListLikes.getListLikesSuccessful();
                }
                break;
            case 23:
                if (option == 1) {
                    System.out.println("1) " + TotalLikesOfAuction.class.getMethod("totalLikesOfAuctionSuccessful").getName());
                    inputOption();
                    TotalLikesOfAuction.totalLikesOfAuctionSuccessful();
                } else {
                    TotalLikesOfAuction.totalLikesOfAuctionSuccessful();
                }
                break;
            case 24:
                if (option == 1) {
                    System.out.println("1) " + GetNews.class.getMethod("getNewsSuccessful").getName());
                    inputOption();
                    GetNews.getNewsSuccessful();
                } else {
                    GetNews.getNewsSuccessful();
                }
                break;
            case 25:
                if (option == 1) {
                    System.out.println("1) " + ReadNew.class.getMethod("readNewSuccessful").getName());
                    inputOption();
                    ReadNew.readNewSuccessful();
                } else {
                    ReadNew.readNewSuccessful();
                }
                break;
            case 26:
                if (option == 1) {
                    System.out.println("1) " + GetNotifications.class.getMethod("getNotificationsIsReadSuccessful").getName());
                    System.out.println("2) " + GetNotifications.class.getMethod("getNotificationsIsNotReadSuccessful").getName());
                    printCommandInputNumberOfUC();
                    int numberOfUC = inputOption();
                    if (numberOfUC == 1) {
                        GetNotifications.getNotificationsIsReadSuccessful();
                    } else {
                        GetNotifications.getNotificationsIsNotReadSuccessful();
                    }
                } else {
                    GetNotifications.getNotificationsIsReadSuccessful();
                    GetNotifications.getNotificationsIsNotReadSuccessful();
                }
                break;
            case 27:
                if (option == 1) {
                    System.out.println("1) " + ReadNotification.class.getMethod("readNotificationSuccessful").getName());
                    printCommandInputNumberOfUC();
                    inputOption();
                    ReadNotification.readNotificationSuccessful();
                } else {
                    ReadNotification.readNotificationSuccessful();
                }
                break;
            case 28:
                if (option == 1) {
                    System.out.println("1) " + GetSlider.class.getMethod("getSliderSuccessful").getName());
                    printCommandInputNumberOfUC();
                    inputOption();
                    GetSlider.getSliderSuccessful();
                } else {
                    GetSlider.getSliderSuccessful();
                }
                break;
            case 29:
                if (option == 1) {
                    System.out.println("1) " + Search.class.getMethod("searchByPriceSuccessful").getName());
                    System.out.println("2) " + Search.class.getMethod("searchByStartDateSuccessful").getName());
                    System.out.println("3) " + Search.class.getMethod("searchByEndDateSuccessful").getName());
                    System.out.println("4) " + Search.class.getMethod("searchByNameSuccessful").getName());
                    printCommandInputNumberOfUC();
                    int numberOfUC = inputOption();
                    if (numberOfUC == 1) {
                        Search.searchByPriceSuccessful();
                    } else if (numberOfUC == 2) {
                        Search.searchByStartDateSuccessful();
                    } else if (numberOfUC == 3) {
                        Search.searchByEndDateSuccessful();
                    } else {
                        Search.searchByNameSuccessful();
                    }
                } else {
                    Search.searchByPriceSuccessful();
                    Search.searchByStartDateSuccessful();
                    Search.searchByEndDateSuccessful();
                    Search.searchByNameSuccessful();
                }
                break;
            case 30:
                if (option == 1) {
                    System.out.println("1) " + DeleteComment.class.getMethod("deleteCommentSuccessful").getName());
                    System.out.println("2) " + DeleteComment.class.getMethod("deleteCommentWhenNotPermission").getName());
                    printCommandInputNumberOfUC();
                    int numberOfUC = inputOption();
                    if (numberOfUC == 1) {
                        DeleteComment.deleteCommentSuccessful();
                    } else {
                        DeleteComment.deleteCommentWhenNotPermission();
                    }
                } else {
                    DeleteComment.deleteCommentSuccessful();
                    DeleteComment.deleteCommentWhenNotPermission();
                }
                break;
        }
    }

    public static void printCommandInputNumberOfUC() {
        System.out.println("Please input number of unit test case: ");
    }

    public static void printDivide() {
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
