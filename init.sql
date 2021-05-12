SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `User`;
DROP TABLE IF EXISTS `Message`;
DROP TABLE IF EXISTS `Groupe`;
DROP TABLE IF EXISTS `Appartient`;
DROP TABLE IF EXISTS `UserMessage`;
DROP TABLE IF EXISTS `Recoit`;
DROP TABLE IF EXISTS `GroupeMessage`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `User` (
    `userId` INTEGER NOT NULL,
    `usename` INTEGER NOT NULL
);

CREATE TABLE `Message` (
    `msgId` INTEGER NOT NULL,
    `message` INTEGER NOT NULL
);

CREATE TABLE `Groupe` (
    `grpId` INTEGER NOT NULL,
    `grpName` INTEGER NOT NULL
);

CREATE TABLE `Appartient` (
    `grpId` INTEGER NOT NULL,
    `userId` INTEGER NOT NULL
);

CREATE TABLE `UserMessage` (
    `receiverId` INTEGER NOT NULL,
    `senderId` INTEGER NOT NULL,
    `msgId` INTEGER NOT NULL
);

CREATE TABLE `Recoit` (
    `userId` INTEGER NOT NULL,
    `Column1` INTEGER NOT NULL
);

CREATE TABLE `GroupeMessage` (
    `grpId` INTEGER NOT NULL,
    `msgId` INTEGER NOT NULL,
    `senderId` INTEGER NOT NULL
);
