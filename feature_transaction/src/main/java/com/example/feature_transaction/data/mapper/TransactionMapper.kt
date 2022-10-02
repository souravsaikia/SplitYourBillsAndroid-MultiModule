package com.example.feature_transaction.data.mapper

import com.example.feature_transaction.data.remote.request.create_transaction.CreateTransactionBody
import com.example.feature_transaction.data.remote.request.create_transaction.CreateTransactionDTO
import com.example.feature_transaction.data.remote.response.SingleSpaceMemberResponse
import com.example.feature_transaction.data.remote.response.all_members_for_space.AllMembersForSpaceResponse
import com.example.feature_transaction.data.remote.response.all_spaces.GetAllSpacesResponse
import com.example.feature_transaction.data.remote.response.create_transaction.CreateTransactionResponse
import com.example.feature_transaction.domain.model.SpaceDetailsResponse

fun GetAllSpacesResponse.toDomainGetAllSpacesResponse(): com.example.feature_transaction.domain.model.response.all_spaces.GetAllSpacesResponse {
    return com.example.feature_transaction.domain.model.response.all_spaces.GetAllSpacesResponse(
        this.success,
        spacesResponse = this.spacesResponse.toDomainSpacesResponse()
    )
}

fun GetAllSpacesResponse.SpacesResponse.toDomainSpacesResponse(): com.example.feature_transaction.domain.model.response.all_spaces.GetAllSpacesResponse.SpacesResponse {
    return com.example.feature_transaction.domain.model.response.all_spaces.GetAllSpacesResponse.SpacesResponse(
        totalMembers = this.totalMembers,
        spaceMembers = getSpaceMembers(this.spaceMembers)
    )
}

fun getSpaceMembers(spaceMembers: List<SingleSpaceMemberResponse>): List<com.example.feature_transaction.domain.model.response.SingleSpaceMemberResponse> {
    val list = mutableListOf<com.example.feature_transaction.domain.model.response.SingleSpaceMemberResponse>()
    spaceMembers.forEach {
        list.add(it.toDomainSingleSpaceMemberResponse())
    }
    return list
}

fun SingleSpaceMemberResponse.toDomainSingleSpaceMemberResponse(): com.example.feature_transaction.domain.model.response.SingleSpaceMemberResponse {
    return com.example.feature_transaction.domain.model.response.SingleSpaceMemberResponse(
        this.spaceMemberId,
        this.spaceId,
        this.personId,
        this.userDetails?.toDomainUserDetails(),
        this.inviteId,
        this.lastUpdated,
        this.joined,
        this.spaceDetailsResponse?.toSpaceDetailsResponseDomain(),
        this.invite?.toInviteDetailsDomain()
    )
}

private fun SingleSpaceMemberResponse.InviteDetails?.toInviteDetailsDomain(): com.example.feature_transaction.domain.model.response.SingleSpaceMemberResponse.InviteDetails {
    return com.example.feature_transaction.domain.model.response.SingleSpaceMemberResponse.InviteDetails(
        this?.inviteID ?: 0,
        this?.spaceId ?: 0,
        this?.phoneNo ?: "",
        this?.inviteName ?: "",
        this?.lastUpdated ?: ""
    )
}

fun SingleSpaceMemberResponse.UserDetails.toDomainUserDetails(): com.example.feature_transaction.domain.model.response.SingleSpaceMemberResponse.UserDetails {
    return com.example.feature_transaction.domain.model.response.SingleSpaceMemberResponse.UserDetails(
        this.phoneNo,
        this.username,
        this.userId
    )
}

fun com.example.feature_transaction.data.remote.response.SpaceDetailsResponse.toSpaceDetailsResponseDomain(): SpaceDetailsResponse {
    return SpaceDetailsResponse(
        this.spaceId,
        this.personId,
        this.spaceName,
        this.spaceDescription,
        this.lastUpdated,
        this.active
    )
}

fun AllMembersForSpaceResponse.toDomainAllMembersForSpaceResponse(): com.example.feature_transaction.domain.model.response.all_member_for_space.AllMembersForSpaceResponse {
    return com.example.feature_transaction.domain.model.response.all_member_for_space.AllMembersForSpaceResponse(
        success = this.success,
        data = this.data.toDomainAllmembersForSpaceResponse()
    )
}

fun AllMembersForSpaceResponse.AllMembersForSpaceResponseData.toDomainAllmembersForSpaceResponse(): com.example.feature_transaction.domain.model.response.all_member_for_space.AllMembersForSpaceResponse.AllMembersForSpaceResponseData {
    return com.example.feature_transaction.domain.model.response.all_member_for_space.AllMembersForSpaceResponse.AllMembersForSpaceResponseData(
        totalMembers = this.totalMembers,
        spaceMemberResponse = getSpaceMembers(this.spaceMemberResponse)
    )
}

fun CreateTransactionBody.toCreateTransactionDTO(): CreateTransactionDTO {
    return CreateTransactionDTO(
        this.spaceId,
        this.transactionName,
        this.transactionDescription
    )
}

fun CreateTransactionResponse.toDomainCreateTransactionResponse(): com.example.feature_transaction.domain.model.response.create_transaction.CreateTransactionResponse {
    return com.example.feature_transaction.domain.model.response.create_transaction.CreateTransactionResponse(
        this.success,
        data = this.data.convertToDomainCreatedTransactionResponse()
    )
}

fun CreateTransactionResponse.CreatedTransactionResponse.convertToDomainCreatedTransactionResponse(): com.example.feature_transaction.domain.model.response.create_transaction.CreateTransactionResponse.CreatedTransactionResponse {
    return com.example.feature_transaction.domain.model.response.create_transaction.CreateTransactionResponse.CreatedTransactionResponse(
        this.transactionId,
        this.spaceId,
        this.transactionName,
        this.transactionDescription,
        this.lastUpdated
    )
}