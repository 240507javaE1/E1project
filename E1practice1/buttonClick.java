		/***按鈕buttonBuy.的動作內容***/														/**=把按鈕取小名叫buttonBuy**/
		JButton buttonBuy = new JButton("購買");//【新增按鈕new JButton】(先給Title叫"購買"),放進【能裝按鈕】盒子buttonBuy*/
		buttonBuy.addMouseListener(new MouseAdapter() {//按鈕.滑鼠監聽器(),類似密切觀察滑鼠想幹嘛的東西吧(ಠ_ಠ)
			int btnClickCounter=0;//偷偷做一個亂按按鈕計數器=0次
			@Override//還不知道這是啥,老師有看到的話還請再解惑
			public void mouseClicked(MouseEvent e) {//當滑鼠按下"購買按鈕"(ಠ_ಠ),就會從這區1行1行往下跑程式碼
				String Name =name.getText();
				String Item1=item1.getText();
				String Item2=item2.getText();
				String Item3=item3.getText();	
				counterShow.setText("\n您輸入錯誤了:"+ (++btnClickCounter) +"次"+ //按紐計數器先+1,然後再印出
									"\n"+		//如果是(btnClickCounter++)的話,就會先印出,然後再把按紐計數器+1
									"\n請不要亂輸入,也不要亂按購買按鈕");//偷雞動作,反正電腦1秒幾十萬行,下面沒卡住就順跑蓋掉了,奈秒血輪眼可能看得到
				//商品小看板不是純數字時,接下來字串會轉不成數字放進int盒子,就會卡在上面那行
				int num_item1=Integer.parseInt(Item1);
				int num_item2=Integer.parseInt(Item2);//請 Integer.解析成int(給字串),放進int盒子
				int num_item3=Integer.parseInt(Item3);	
				//好像還是能放-負整數,處理一下
				if(num_item1<0 || num_item2<0 || num_item3<0) { //如果商品數量是-負整數的話,用絕對值的方式,幫忙改成正整數,
					counterShow.setText("\n您輸入錯誤了:"+ btnClickCounter +"次"+
										"\n"+
										"\n我猜您不小心多寫了-號,已經幫您移除-號,請您再次確認後重新按購買");
					item1.setText(Integer.toString(Math.abs(num_item1))); //只能放文字,不能放數字,請 Integer.轉String(給整數)
					item2.setText(""+Math.abs(num_item2));//只能放文字,所以用空字串(""+數字)來轉字串
					item3.setText(Math.abs(num_item3)+"");//只能放文字,所以用空字串(數字+"")來轉字串
					int makeErrorToStopAtHere=Integer.parseInt("想觸發錯誤不往下跑,故意填個不能轉數字的字串"); //想故意makeError不往下跑,感覺不是個好的做法
				}/**到這邊可以確定商品數量都是0或正整數**/	
					/**Name檢查是否空白,空白會改成未填寫**/		
				if(name.getText().isEmpty()) Name="未填寫";/*if()只有1行要做,可以省大括號*/						/**=把訂單取小名叫bill**/															/**=把1個訂單取小名叫bill**/
				Order bill=new Order(Name,num_item1,num_item2,num_item3);//【新增訂單new Order】(先給數量123),放進【能裝訂單】盒子bill
				if(checkVIP.isSelected()==true) {//if(請 checkVIP.勾選動作(),是true嗎)
					if(bill.getSum()>=2000) {	//是VIP,if(請 bill.給Sum,>=2000嗎)
						counterShow.setText(bill.show()+
											"\n您是會員,打9折="+bill.getSum()*0.9+
											"\n消費滿2000,再打95折="+bill.getSum()*0.9*0.95+
											"\n"+ 
											"\n請付總價 : "+bill.getSum()*0.9*0.95);
					} else {
						counterShow.setText(bill.show()+
											"\n您是會員,打9折="+bill.getSum()*0.9+
											"\n"+
											"\n請付總價 : "+bill.getSum()*0.9);
					}
				} else if(bill.getSum()>=2000) counterShow.setText(bill.show()+
						"\n您不是會員,未折價="+bill.getSum()+
						"\n消費滿2000,打95折="+bill.getSum()*0.95+
						"\n"+ 
						"\n請付總價 : "+bill.getSum()*0.95);//elseif只有1行要做,可以省大括號,java用分號;辨認程式碼,這是1行指令,沒問題
				else counterShow.setText(bill.show()+
						"\n您不是會員,未折價="+bill.getSum()+
						"\n"+ 
						"\n請付總價 : "+bill.getSum());//else只有1行要做,可以省大括號,java用分號;辨認程式碼,這是1行指令,沒問題
				
				btnClickCounter=0;//結帳結果有跑成功的話,重置亂按計數器的次數,當你沒有亂按過
			}
		});
		buttonBuy.setFont(new Font("標楷體", Font.BOLD, 24));
		buttonBuy.setBounds(193, 304, 183, 53);
		panel_1.add(buttonBuy);
		/***按鈕buttonErase.的動作內容***/
		//【新增按鈕new JButton】(先給Title叫"html換行相關的東西"),放進【能裝按鈕】盒子buttonErase
		JButton buttonErase = new JButton("<html>清空姓名&會員"+
										"<br />清空商品數量"+
										"<br /><center>&"+
										"<br />清空</center>"+
										"<br />上個結帳結果</html>");//Jbutton不吃/n,好險有吃HTML語法<br />換行
		buttonErase.addMouseListener(new MouseAdapter() {//按鈕.滑鼠監聽器(ಠ_ಠ)
			@Override
			public void mouseClicked(MouseEvent e) {//當滑鼠按下"清空按鈕"(ಠ_ಠ),就會從這區1行1行往下跑程式碼
				name.setText(""); checkVIP.setSelected(false);
				item1.setText("");
				item2.setText("");
				item3.setText("");
				
				counterShow.setText("");
			}
		});
		//buttonErase.setText("<html>清空姓名 &<br />清空商品數量</html>");//廢案,new的時候取好名就好,這次當作學習記錄留著
		buttonErase.setFont(new Font("標楷體", Font.BOLD | Font.ITALIC, 20));
		buttonErase.setBounds(379, 90, 181, 192);
		panel_1.add(buttonErase);

	}