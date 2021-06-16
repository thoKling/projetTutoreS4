package com.example.projet_tutore_back.rest.webservice

import com.example.projet_tutore_back.data.dto.AddRemoveUserToGroupDto
import com.example.projet_tutore_back.data.entity.GroupChat
import com.example.projet_tutore_back.data.service.GroupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/group")
class GroupWS @Autowired constructor(
    val groupService: GroupService
) {
    @PostMapping("/create")
    fun create(@RequestBody messageReq: MutableList<String>) {
        groupService.createGroup(messageReq)
    }
    @GetMapping("/getGroupsWithUser/{userId}")
    fun getGroupsWithUser(@PathVariable userId: String): MutableList<GroupChat> {
        return groupService.retrieveGroups(userId)
    }
    @GetMapping("/getGroup/{groupId}")
    fun getGroup(@PathVariable groupId: Long): GroupChat {
        return groupService.getGroup(groupId);
    }
    @PostMapping("/removeUser")
    fun removeUser(@RequestBody messageReq: AddRemoveUserToGroupDto) {
        groupService.removeFromGroup(messageReq.groupId, messageReq.userId)
    }
    @PostMapping("/addUser")
    fun addUser(@RequestBody messageReq: AddRemoveUserToGroupDto) {
        groupService.addToGroup(messageReq.groupId, messageReq.userId)
    }
}
