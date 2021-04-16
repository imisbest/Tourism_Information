
drop table ti_user cascade constraint;
create table ti_user(
username varchar2(3) primary key  not null,
password varchar2(40),
email varchar2(20)
);
commit;
select * from ti_user;
insert into ti_user values('qqq','qqq','qqq@qq.com');

drop sequence ti_pro_seq;
create sequence ti_pro_seq;
drop table ti_province cascade constraint;
create table ti_province(
id number(3) primary key  not null,
province varchar2(100),
taglib varchar2(100),
spots number(3)
);
commit;
insert into ti_province values(ti_pro_seq.nextval,'北京市','首都，天安门',3);
insert into ti_province values(ti_pro_seq.nextval,'山东省','  啤酒节、风筝节',  0);
insert into ti_province values(ti_pro_seq.nextval,'河南省','  唐三彩、少林寺',  0);
insert into ti_province values(ti_pro_seq.nextval,'辽宁省','  二人转、小品',  0);
insert into ti_province values(ti_pro_seq.nextval,'广西壮族自治区','  桂林山水、少数名族聚居地',  0);
commit;
select * from ti_province;

drop sequence ti_sce_seq;
create sequence ti_sce_seq;
drop table ti_scenicSpots cascade constraint;
create table ti_scenicSpots(
id number(3) primary key not null,
scenic varchar2(20),
cover varchar2(100),
peakSeason varchar2(20),
hprice varchar2(10),
lprice varchar2(10),
introduction varchar2(500),
sid number(3)
);
commit;
insert into ti_scenicSpots values(ti_sce_seq.nextval,'天安门','tianam.jpg','1月-2月','68','98','天安门，坐落在中华人民共和国首都北京市的中心、故宫的南端，与天安门广场以及人民英雄纪念碑、毛主席纪念堂、人民大会堂、中国国家博物馆隔长安街相望，占地面积4800平方米，以杰出的建筑艺术和特殊的政治地位为世人所瞩目。',1);
insert into ti_scenicSpots values(ti_sce_seq.nextval,'故宫','gug.jpg','3月-4月','33','66','北京故宫是中国明清两代的皇家宫殿，旧称紫禁城，位于北京中轴线的中心，是中国古代宫廷建筑之精华。北京故宫以三大殿为中心，占地面积72万平方米，建筑面积约15万平方米，有大小宫殿七十多座，房屋九千余间。是世界上现存规模最大、保存最为完整的木质结构古建筑之一。',1);
insert into ti_scenicSpots values(ti_sce_seq.nextval,'颐和园','yihy.jpg','9月-11月','55','88','颐和园，中国清朝时期皇家园林，前身为清漪园，坐落在北京西郊，距城区15公里，占地约290公顷，与圆明园毗邻。它是以昆明湖、万寿山为基址，以杭州西湖为蓝本，汲取江南园林的设计手法而建成的一座大型山水园林，也是保存最完整的一座皇家行宫御苑，被誉为“皇家园林博物馆”，也是国家重点旅游景点。',1);
commit;

