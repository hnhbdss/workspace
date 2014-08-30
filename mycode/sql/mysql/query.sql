select ugw.*, usn.*, gxy.* from 
(select sno, imsi, imsdn, proceduretype, accesstime, releasetime from r_comp where netype in (4) and proceduretype in (10)) ugw

left outer join 

(select sno, imsi, imsdn, proceduretype, accesstime, releasetime from r_comp where netype in (3) and proceduretype in (1, 2 , 3)) usn

on ((ugw.imsi = usn.imsi) and not (ugw.imsdn is not null and usn.imsdn is not null and ugw.imsdn <> usn.imsdn) 
    and ((ugw.accesstime- usn.accesstime) < 5 and (ugw.accesstime > usn.accesstime)))

left outer join 

(select sno, imsi, imsdn, proceduretype, accesstime, releasetime from r_comp where netype in (4) and proceduretype in (100, 101)) gxy

on ((ugw.imsi = gxy.imsi) and not (ugw.imsdn is not null and gxy.imsdn is not null and ugw.imsdn <> gxy.imsdn) 
   and ((gxy.accesstime - ugw.accesstime) < 5) and (gxy.accesstime > ugw.accesstime))
   
where (usn.sno is not null or gxy.sno is not null)

;
