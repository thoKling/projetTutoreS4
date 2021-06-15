package com.example.projet_tutore_back.rest.webservice

import com.example.projet_tutore_back.data.dto.MessageSendReqDto
import com.example.projet_tutore_back.data.entity.GroupMessage
import com.example.projet_tutore_back.data.service.GroupMessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/message")
class MessageWS(
    @Autowired
    val groupMessageService: GroupMessageService
) {
    @PostMapping("/send")
    fun sendMessage(@RequestBody messageReq: MessageSendReqDto) {
        groupMessageService.sendMessageToGroup(messageReq)
    }
    @GetMapping("/messagesInGroup/{groupId}")
    fun getChatWithUser(@PathVariable groupId: Long): List<GroupMessage> {
        return groupMessageService.getMessageInGroup(groupId)
    }
}
