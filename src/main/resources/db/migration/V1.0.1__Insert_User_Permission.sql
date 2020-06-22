INSERT INTO "user"
(id, user_name, full_name, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, created_at, updated_at)
VALUES ('86a7b14b-7c43-4fc3-9827-c71ec7ff376b', 'ricardo', 'Ricardo Corrent',
        '$2a$16$9qr2tv0HmXbHBsx.TZFjfux742wCZM32a8Wi6iBqwIqaizlHPuxHS', '1', '1', '1', '1', now(), now()),
       ('2dc6dce2-244e-4410-b127-058061ad960f', 'admin', 'Sys admin',
        '$2a$16$h4yDQCYTy62R6xrtFDWONeMH3Lim4WQuU/aj8hxW.dJJoeyvtEkhK', '1', '1', '1', '1', now(), now());


INSERT INTO permission (id, description)
VALUES ('43b08f8b-12bc-4c6c-855a-4a55e748c40b', 'ADMIN');


INSERT INTO permission (id, description)
VALUES ('4f152572-307c-4edf-bcfd-24eba0a01f55', 'MANAGER');


INSERT INTO permission (id, description)
VALUES ('ca2e080d-a0f5-43f7-bfa1-80bb68ac9440', 'COMMONS');

INSERT INTO user_permission (user_id, permission_id)
VALUES ('86a7b14b-7c43-4fc3-9827-c71ec7ff376b', '43b08f8b-12bc-4c6c-855a-4a55e748c40b'),
       ('86a7b14b-7c43-4fc3-9827-c71ec7ff376b', '4f152572-307c-4edf-bcfd-24eba0a01f55'),
       ('2dc6dce2-244e-4410-b127-058061ad960f', '43b08f8b-12bc-4c6c-855a-4a55e748c40b');
