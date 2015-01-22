package asclib.net;

public interface ChannelInst {
	// instructions channel will receive
	final int ITMT_NEW		=	0;	// �½��ⲿ���ӣ�(id,tag) ip/d,port/w   <hid>
	final int ITMT_LEAVE	=	1;	// �Ͽ��ⲿ���ӣ�(id,tag)           <hid>
	final int ITMT_DATA		=	2;	// �ⲿ���ݵ��(id,tag) data...    <hid>
	final int ITMT_CHANNEL	=	3;	// Ƶ��ͨ�ţ�(channel,tag)    <>
	final int ITMT_CHNEW	=	4;	// Ƶ��������(channel,id)
	final int ITMT_CHSTOP	=	5;	// Ƶ���Ͽ���(channel,tag)
	final int ITMT_SYSCD	=	6;	// ϵͳ��Ϣ��(subtype, v) data...
	final int ITMT_TIMER	=	7;	// ϵͳʱ�ӣ�(timesec,timeusec)
	final int ITMT_UNRDAT	=	10;	// ���ɿ����ݰ���(id,tag)
	final int ITMT_NOOP		=	80;	// ��ָ�(wparam, lparam)
	//final int ITMT_BLOCK	=	99;	// û��ָ��
	
	// instructions from channel to transmod
	final int ITMC_DATA		=	0;	// �ⲿ���ݷ��ͣ�(id,*) data...
	final int ITMC_CLOSE	=	1;	// �ر��ⲿ���ӣ�(id,code)
	final int ITMC_TAG		=	2;	// ����TAG��(id,tag)
	final int ITMC_CHANNEL	=	3;	// ���ͨ�ţ�(channel,*) data...
	final int ITMC_MOVEC	=	4;	// �ƶ��ⲿ���ӣ�(channel,id) data...
	final int ITMC_SYSCD	=	5;	// ϵͳ������Ϣ��(subtype, v) data...
	final int ITMC_BROADCAST	=	6;	// �㲥
	final int ITMC_UNRDAT	=	10;	// ���ɿ����ݰ���(id,tag)
	final int ITMC_IOCTL	=	11;	// ���ӿ���ָ�(id,flag)
	//final int ITMC_SEED		=	12;	// ���ü�������
	final int ITMC_NOOP		=	80;	// ��ָ�(*,*)

	// the sub instructions for the ITMC_SYSINFO
	final int ITMS_CONNC	=	0;	// ������������(st,0) cu/d,cc/d
	final int ITMS_LOGLV	=	1;	// ������־����(st,level)
	final int ITMS_LISTC	=	2;	// ����Ƶ����Ϣ(st,cn) d[ch,id,tag],w[t,c]
	final int ITMS_RTIME	=	3;	// ϵͳ����ʱ��(st,wtime)
	final int ITMS_TMVER	=	4;	// ����ģ��汾(st,tmver)
	final int ITMS_REHID	=	5;	// ����Ƶ����(st,ch)
	final int ITMS_QUITD	=	6;	// �����Լ��˳�
	//final int ITMS_NODELAY	=	7;	// ���ý���Nagle�㷨
	final int ITMS_TIMER	=	8;	// ����Ƶ�����ʱ��(st,timems)
	//final int ITMS_INTERVAL	=	9;	// �����Ƿ�Ϊ���ģʽ(st,isinterval)
	final int ITMS_FASTMODE	=	10;	// �����Ƿ����ÿ���ģʽ
	final int ITMS_CHID		=	11;	// ȡ���Լ���channel���(st, ch)
	final int ITMS_BOOKADD	=	12;	// ���Ӷ���
	final int ITMS_BOOKDEL	=	13;	// ȡ������
	final int ITMS_BOOKRST	=	14;	// ��ն���
	final int ITMS_STATISTIC	=	15;	// ͳ����Ϣ
	final int ITMS_RC4SKEY	=	16;	// ���÷���KEY (st, hid) key
	final int ITMS_RC4RKEY	=	17;	// ���ý���KEY (st, hid) key
	final int ITMS_DISABLE	=	18;	// ��ֹ���ո��û���Ϣ
	final int ITMS_ENABLE	=	19;	// ������ո��û���Ϣ
	final int ITMS_SETDOC	=	20;	// �ĵ�����
	final int ITMS_GETDOC	=	21;	// �ĵ���ȡ
	final int ITMS_MESSAGE	=	22;	// �ⲿ�����¼�
	
	final int ITMS_NODELAY	=	1;	// ���ӿ��ƣ�������������ģʽ
	final int ITMS_NOPUSH	=	2;	// ���ӿ��ƣ���������������
	final int ITMS_PRIORITY	=	3;	// SO_PRIORITY
	final int ITMS_TOS		=	4;	// IP_TOS
	
	// for log
	final int ITML_BASE		=	0x01; // ��־���룺����
	final int ITML_INFO		=	0x02; // ��־���룺��Ϣ
	final int ITML_ERROR	=	0x04; // ��־���룺����
	final int ITML_WARNING	=	0x08; // ��־���룺����
	final int ITML_DATA		=	0x10; // ��־���룺����
	final int ITML_CHANNEL	=	0x20; // ��־���룺Ƶ��
	final int ITML_EVENT	=	0x40; // ��־���룺�¼�
	final int ITML_LOST		=	0x80; // ��־���룺������¼			
}
