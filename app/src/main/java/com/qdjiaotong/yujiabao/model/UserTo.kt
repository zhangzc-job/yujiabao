package com.qdjiaotong.yujiabao.model

data class UserTo(
    val __url: String,
    val message: String,
    val result: String,
    val sessionid: String,
    val user: User
)

data class User(
    val avatarUrl: String,
    val corpCode_: String,
    val corpName_: String,
    val createBy: String,
    val createDate: String,
    val email: String,
    val extend: Extend,
    val id: String,
    val isNewRecord: Boolean,
    val lastLoginDate: String,
    val lastLoginIp: String,
    val loginCode: String,
    val mgrType: String,
    val mobile: String,
    val oldLastLoginIp: String,
    val oldLoginDate: String,
    val phone: String,
    val refCode: String,
    val refName: String,
    val refObj: RefObj,
    val remarks: String,
    val status: String,
    val updateBy: String,
    val updateDate: String,
    val userCode: String,
    val userName: String,
    val userType: String,
    val userWeight: Int
)

data class Extend(
    val extendS1: String,
    val extendS2: String,
    val extendS3: String,
    val extendS4: String,
    val extendS5: String,
    val extendS6: String,
    val extendS7: String,
    val extendS8: String
)

data class RefObj(
    val company: Company,
    val createBy: String,
    val createDate: String,
    val empCode: String,
    val empName: String,
    val empNameEn: String,
    val empNo: String,
    val employeeOfficeList: List<Any>,
    val employeePostList: List<Any>,
    val employeePosts: List<Any>,
    val id: String,
    val isNewRecord: Boolean,
    val office: Office,
    val status: String,
    val updateBy: String,
    val updateDate: String
)

data class Company(
    val companyCode: String,
    val companyName: String,
    val companyOfficeList: List<Any>,
    val isNewRecord: Boolean,
    val isRoot: Boolean,
    val isTreeLeaf: Boolean
)

data class Office(
    val address: String,
    val createBy: String,
    val createDate: String,
    val email: String,
    val extend: ExtendX,
    val fullName: String,
    val id: String,
    val isNewRecord: Boolean,
    val isRoot: Boolean,
    val isTreeLeaf: Boolean,
    val leader: String,
    val officeCode: String,
    val officeName: String,
    val officeType: String,
    val parentCode: String,
    val parentCodes: String,
    val phone: String,
    val remarks: String,
    val status: String,
    val treeLeaf: String,
    val treeLevel: Int,
    val treeNames: String,
    val treeSort: Int,
    val treeSorts: String,
    val updateBy: String,
    val updateDate: String,
    val viewCode: String,
    val zipCode: String
)

data class ExtendX(
    val extendS1: String,
    val extendS2: String,
    val extendS3: String,
    val extendS4: String,
    val extendS5: String,
    val extendS6: String,
    val extendS7: String,
    val extendS8: String
)