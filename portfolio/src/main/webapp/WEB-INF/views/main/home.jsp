<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="header">
	<div class="wrap">
		<div class="box-menu">
			<div class="side-menu">
				<h1>
					<a class="logo"
						href="http://127.0.0.1:5500/bus-ticketing/html/bus-ticketing.html">
						버스예매포트폴리오 </a>

				</h1>
				<ul>
					<li><a href="#" aria-selected="true" data-target="#ticket-box">고속버스
							예매</a></li>
					<li><a href="#" data-target=".ticket-confirm">예매확인</a></li>
					<li><a href="#">운행정보</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<div class="main-container">
	<div class="tic-wrap ticketing-container">
		<div class="tic-box" id="ticket-box">
			<ul class="route-box">
				<li class="one-way active"><a href="#"> 편도</a></li>
				<li class="round-trip"><a href="#">왕복</a></li>
			</ul>
			<ul class="place-box">
				<li class="start" data-target=".remodal-overlay,.remodal-wrapper">
					<a href="#" id="readDeprInfoList"> <span class="name">출발지</span>
						<p class="text empty">
							<span class="empty_txt">출발지 선택</span> <span class="val-txt"
								id="deprNmSpn"></span>
						</p> <!-- 값 있을 경우 empty 클래스 없음 -->
				</a>
					<p class="button-change"></p>
				</li>
				<li class="arrival" data-target=".remodal-overlay,.remodal-wrapper">
					<a href="#" id="readArvlInfoList"> <span class="name">도착지</span>
						<p class="text empty">
							<span class="empty_txt">도착지 선택</span> <span class="val-txt"
								id="arvlNmSpn"></span>
						</p>
				</a>
				</li>
			</ul>
			<ul class="date-box">
				<li>
					<div class="date">
						<span class="name">가는날</span>
						<p class="text">
							<input type="text" id="calender">
						</p>
					</div>
				</li>
			</ul>
			<ul class="grade-box">
				<li>
					<div class="grade">
						<span class="name">등급</span>
						<p>
							<span class="custom_radio gradeAll"	style="margin-left: 19px; font-size: 25px; position: relative; right: 72px;">
								<input type="radio" id="busClsCd0" name="busClsCdR"
								onclick="fnBusClsCd(this)" value="0" /> <label for="busClsCd0">전체</label>
							</span> <span class="custom_radio grade2" style="margin-left: 19px;">
								<input type="radio" id="busClsCd1" name="busClsCdR"
								onclick="fnBusClsCd(this)" value="1" /> <label for="busClsCd1">우등</label>
							</span> <span class="custom_radio grade3" style="margin-left: 19px;">
								<input type="radio" id="busClsCd5" name="busClsCdR"
								onclick="fnBusClsCd(this)" value="2" /> <label for="busClsCd5">일반</label>
							</span>
						</p>
					</div>

				</li>
			</ul>
			<div class="complete">
				<button type="button" class="btn-complete">조회하기</button>
			</div>
		</div>
		<div class="remodal-overlay remodal-is-opened" style="display: none"></div>
		<div class="remodal-wrapper full remodal-is-opened"
			style="display: none">
			<div
				class="remodal pop_place full remodal-is-initialized remodal-is-opened"
				style="display: none">
				<div class="title">출/도착지 선택</div>
				<button data-remodal-action="close" class="remodal-close"
					aria-label="Close" data-target=".remodal-overlay,.remodal-wrapper"></button>
				<div class="cont">
					<div class="place">
						<!--focus-->
						<ul>
							<li class="focuson"><span class="stit">출발지</span>
								<p class="text empty">
									<span class="empty_txt">선택</span> <span class="val_txt"
										id="popDeprNmSpn"></span>
								</p></li>
							<li><span class="stit">도착지</span>
								<p class="text empty">
									<span class="empty_txt">선택</span> <span class="val_txt"
										id="popDeprNmSpn"></span>
								</p></li>
						</ul>
						<p class="btn_change">
							<i class="far fa-arrow-alt-circle-right"></i>
						</p>
					</div>
					<div class="search_wrap">
						<p class="focus">
						<div class="easy-autocomplete" style="width: 620px;">
							<input type="text" id="terminalSearch" title="터미널/지역 이름 검색"
								placeholder="터미널/지역 이름 검색하세요" autocomplete="off">
							<div class="easy-autocomplete-container"
								id="eac-container-terminalSearch">
								<ul style="display: none;">
									<li>
										<div class="eac-item">
											대전<b>청</b>사
										</div>
									</li>
									<li>
										<div class="eac-item">
											세종<b>청</b>사
										</div>
									</li>
									<li>
										<div class="eac-item">
											세종시<b>청</b>
										</div>
									</li>
									<li>
										<div class="eac-item">
											<b>청</b>양
										</div>
									</li>
									<li>
										<div class="eac-item">
											<b>청</b>주고속터미널
										</div>
									</li>
									<li>
										<div class="eac-item">
											<b>청</b>주(센트럴)
										</div>
									</li>
								</ul>
							</div>
						</div>
						<span class="btn">검색<i class="fas fa-search"></i></span>
						</p>
					</div>
					<div class="terminal_wrap">
						<p class="stit">지역별 터미널</p>
						<div class="ternimal_box">
							<div class="scroll-wrapper area_scroll scrollbar-inner"
								style="position: relative;">
								<div class="area_scroll scrollbar-inner scroll-content"
									style="height: 420px; margin-bottom: 0px; margin-right: 0px; max-height: none;">
									<ul class="area_list">
										<li class="active" id="areaListAll"><span
											onclick="fnDeprArvlViewList('all');">전체</span></li>
										<li class=""><span onclick="fnDeprArvlViewList('11');">서울</span></li>
										<li class=""><span onclick="fnDeprArvlViewList('28');">인천/경기</span></li>
										<li class=""><span onclick="fnDeprArvlViewList('42');">강원</span></li>
										<li><span onclick="fnDeprArvlViewList('30');">대전/충남</span></li>
										<li><span onclick="fnDeprArvlViewList('43');">충북</span></li>
										<li><span onclick="fnDeprArvlViewList('29');">광주/전남</span></li>
										<li><span onclick="fnDeprArvlViewList('45');">전북</span></li>
										<li><span onclick="fnDeprArvlViewList('26');">부산/경남</span></li>
										<li><span onclick="fnDeprArvlViewList('27');">대구/경북</span></li>
									</ul>
								</div>
								<div class="scroll-element scroll-x">
									<div class="scroll-element_outer">
										<div class="scroll-element_size"></div>
										<div class="scroll-element_track"></div>
										<div class="scroll-bar" style="width: 100px; left: 0px;"></div>
									</div>
								</div>
								<div class="scroll-element scroll-y">
									<div class="scroll-element_outer">
										<div class="scroll-element_size"></div>
										<div class="scroll-element_track"></div>
										<div class="scroll-bar" style="height: 100px; top: 0px;"></div>
									</div>
								</div>
							</div>
							<div class="terminal_list" id="terminalList">
								<div class="scroll-wrapper terminal_scroll scrollbar-inner"
									style="position: relative;">
									<div
										class="terminal_scroll scrollbar-inner scroll-content scroll-scrolly_visible"
										style="height: auto; margin-bottom: 0px; margin-right: 0px; max-height: 420px;">
										<ul class="clear" id="tableTrmList">
											<li class="over"><span onclick="fnDeprChc('200','강릉');">강릉</span></li>
											<li><span onclick="fnDeprChc('535','강진');">강진</span></li>
											<li><span onclick="fnDeprChc('852','경북도청');">경북도청</span></li>
											<li><span onclick="fnDeprChc('815','경주');">경주</span></li>
											<li><span onclick="fnDeprChc('355','고대조치원');">고대조치원</span></li>
											<li><span onclick="fnDeprChc('116','고양백석');">고양백석</span></li>
											<li><span onclick="fnDeprChc('115','고양화정');">고양화정</span></li>
											<li><span onclick="fnDeprChc('635','고창');">고창</span></li>
											<li><span onclick="fnDeprChc('540','고흥');">고흥</span></li>
											<li><span onclick="fnDeprChc('320','공주');">공주</span></li>
											<li><span onclick="fnDeprChc('125','광명(KTX역)');">광명(KTX역)</span></li>
											<li><span onclick="fnDeprChc('126','광명(철산역)');">광명(철산역)</span></li>
											<li><span onclick="fnDeprChc('520','광양');">광양</span></li>
											<li><span onclick="fnDeprChc('500','광주(유·스퀘어)');">광주(유·스퀘어)</span></li>
											<li><span onclick="fnDeprChc('519','구례');">구례</span></li>
											<li><span onclick="fnDeprChc('169','구리');">구리</span></li>
											<li><span onclick="fnDeprChc('810','구미');">구미</span></li>
											<li><span onclick="fnDeprChc('610','군산');">군산</span></li>
											<li><span onclick="fnDeprChc('330','금산');">금산</span></li>
											<li><span onclick="fnDeprChc('620','김제');">김제</span></li>
											<li><span onclick="fnDeprChc('820','김천');">김천</span></li>
											<li><span onclick="fnDeprChc('821','김천혁신');">김천혁신</span></li>
											<li><span onclick="fnDeprChc('735','김해');">김해</span></li>
											<li><span onclick="fnDeprChc('736','김해장유');">김해장유</span></li>
											<li><span onclick="fnDeprChc('530','나주');">나주</span></li>
											<li><span onclick="fnDeprChc('824','낙동강(휴)상행');">낙동강(휴)상행</span></li>
											<li><span onclick="fnDeprChc('823','낙동강(휴)하행');">낙동강(휴)하행</span></li>
											<li><span onclick="fnDeprChc('592','남악');">남악</span></li>
											<li><span onclick="fnDeprChc('625','남원');">남원</span></li>
											<li><span onclick="fnDeprChc('390','내포');">내포</span></li>
											<li><span onclick="fnDeprChc('545','녹동');">녹동</span></li>
											<li><span onclick="fnDeprChc('370','논산');">논산</span></li>
											<li><span onclick="fnDeprChc('587','능주');">능주</span></li>
											<li><span onclick="fnDeprChc('582','담양');">담양</span></li>
											<li><span onclick="fnDeprChc('312','당진');">당진</span></li>
											<li><span onclick="fnDeprChc('388','당진기지시');">당진기지시</span></li>
											<li><span onclick="fnDeprChc('807','대구용계');">대구용계</span></li>
											<li><span onclick="fnDeprChc('809','대구혁신');">대구혁신</span></li>
											<li><span onclick="fnDeprChc('307','대전도룡');">대전도룡</span></li>
											<li><span onclick="fnDeprChc('300','대전복합');">대전복합</span></li>
											<li><span onclick="fnDeprChc('305','대전청사');">대전청사</span></li>
											<li><span onclick="fnDeprChc('626','덕과');">덕과</span></li>
											<li><span onclick="fnDeprChc('399','덕산스파');">덕산스파</span></li>
											<li><span onclick="fnDeprChc('525','동광양');">동광양</span></li>
											<li><span onclick="fnDeprChc('801','동대구');">동대구</span></li>
											<li><span onclick="fnDeprChc('032','동서울');">동서울</span></li>
											<li><span onclick="fnDeprChc('210','동해');">동해</span></li>
											<li><span onclick="fnDeprChc('705','마산');">마산</span></li>
											<li><span onclick="fnDeprChc('706','마산내서');">마산내서</span></li>
											<li><span onclick="fnDeprChc('505','목포');">목포</span></li>
											<li><span onclick="fnDeprChc('550','무안');">무안</span></li>
											<li><span onclick="fnDeprChc('584','문장');">문장</span></li>
											<li><span onclick="fnDeprChc('750','밀양');">밀양</span></li>
											<li><span onclick="fnDeprChc('337','배방정류소');">배방정류소</span></li>
											<li><span onclick="fnDeprChc('555','벌교');">벌교</span></li>
											<li><span onclick="fnDeprChc('554','보성');">보성</span></li>
											<li><span onclick="fnDeprChc('700','부산');">부산</span></li>
											<li><span onclick="fnDeprChc('101','부천');">부천</span></li>
											<li><span onclick="fnDeprChc('405','북청주');">북청주</span></li>
											<li><span onclick="fnDeprChc('220','삼척');">삼척</span></li>
											<li><span onclick="fnDeprChc('591','삼호');">삼호</span></li>
											<li><span onclick="fnDeprChc('040','상봉');">상봉</span></li>
											<li><span onclick="fnDeprChc('825','상주');">상주</span></li>
											<li><span onclick="fnDeprChc('805','서대구');">서대구</span></li>
											<li><span onclick="fnDeprChc('703','서부산(사상)');">서부산(사상)</span></li>
											<li><span onclick="fnDeprChc('393','서산');">서산</span></li>
											<li><span onclick="fnDeprChc('109','서수원');">서수원</span></li>
											<li><span onclick="fnDeprChc('010','서울경부');">서울경부</span></li>
											<li><span onclick="fnDeprChc('347','선문대');">선문대</span></li>
											<li><span onclick="fnDeprChc('813','선산(휴)상행');">선산(휴)상행</span></li>
											<li><span onclick="fnDeprChc('812','선산(휴)하행');">선산(휴)하행</span></li>
											<li><span onclick="fnDeprChc('529','섬진강(휴)상행');">섬진강(휴)상행</span></li>
											<li><span onclick="fnDeprChc('528','섬진강(휴)하행');">섬진강(휴)하행</span></li>
											<li><span onclick="fnDeprChc('120','성남(분당)');">성남(분당)</span></li>
											<li><span onclick="fnDeprChc('361','세종국무조정실');">세종국무조정실</span></li>
											<li><span onclick="fnDeprChc('362','세종시청');">세종시청</span></li>
											<li><span onclick="fnDeprChc('351','세종연구단지');">세종연구단지</span></li>
											<li><span onclick="fnDeprChc('353','세종청사');">세종청사</span></li>
											<li><span onclick="fnDeprChc('352','세종터미널');">세종터미널</span></li>
											<li><span onclick="fnDeprChc('020','센트럴시티(서울)');">센트럴시티(서울)</span></li>
											<li><span onclick="fnDeprChc('230','속초');">속초</span></li>
											<li><span onclick="fnDeprChc('110','수원');">수원</span></li>
											<li><span onclick="fnDeprChc('645','순창');">순창</span></li>
											<li><span onclick="fnDeprChc('515','순천');">순천</span></li>
											<li><span onclick="fnDeprChc('513','순천신대지구');">순천신대지구</span></li>
											<li><span onclick="fnDeprChc('195','시흥(시화)');">시흥(시화)</span></li>
											<li><span onclick="fnDeprChc('114','신갈시외');">신갈시외</span></li>
											<li><span onclick="fnDeprChc('119','신갈영덕');">신갈영덕</span></li>
											<li><span onclick="fnDeprChc('344','아산둔포');">아산둔포</span></li>
											<li><span onclick="fnDeprChc('341','아산서부(호서대)');">아산서부(호서대)</span></li>
											<li><span onclick="fnDeprChc('340','아산온양');">아산온양</span></li>
											<li><span onclick="fnDeprChc('342','아산탕정사무소');">아산탕정사무소</span></li>
											<li><span onclick="fnDeprChc('338','아산테크노밸리');">아산테크노밸리</span></li>
											<li><span onclick="fnDeprChc('840','안동');">안동</span></li>
											<li><span onclick="fnDeprChc('396','안면도');">안면도</span></li>
											<li><span onclick="fnDeprChc('190','안산');">안산</span></li>
											<li><span onclick="fnDeprChc('130','안성');">안성</span></li>
											<li><span onclick="fnDeprChc('133','안성공도');">안성공도</span></li>
											<li><span onclick="fnDeprChc('137','안성대림');">안성대림</span></li>
											<li><span onclick="fnDeprChc('131','안성중대');">안성중대</span></li>
											<li><span onclick="fnDeprChc('132','안성풍림');">안성풍림</span></li>
											<li><span onclick="fnDeprChc('134','안성한경');">안성한경</span></li>
											<li><span onclick="fnDeprChc('138','안성회관');">안성회관</span></li>
											<li><span onclick="fnDeprChc('177','안중');">안중</span></li>
											<li><span onclick="fnDeprChc('176','안중오거리');">안중오거리</span></li>
											<li><span onclick="fnDeprChc('619','애통리');">애통리</span></li>
											<li><span onclick="fnDeprChc('745','양산');">양산</span></li>
											<li><span onclick="fnDeprChc('270','양양');">양양</span></li>
											<li><span onclick="fnDeprChc('510','여수');">여수</span></li>
											<li><span onclick="fnDeprChc('140','여주');">여주</span></li>
											<li><span onclick="fnDeprChc('139','여주대');">여주대</span></li>
											<li><span onclick="fnDeprChc('509','여천');">여천</span></li>
											<li><span onclick="fnDeprChc('380','연무대');">연무대</span></li>
											<li><span onclick="fnDeprChc('560','영광');">영광</span></li>
											<li><span onclick="fnDeprChc('843','영덕');">영덕</span></li>
											<li><span onclick="fnDeprChc('565','영산포');">영산포</span></li>
											<li><span onclick="fnDeprChc('570','영암');">영암</span></li>
											<li><span onclick="fnDeprChc('835','영주');">영주</span></li>
											<li><span onclick="fnDeprChc('845','영천');">영천</span></li>
											<li><span onclick="fnDeprChc('846','영천망정동');">영천망정동</span></li>
											<li><span onclick="fnDeprChc('112','영통');">영통</span></li>
											<li><span onclick="fnDeprChc('398','예산');">예산</span></li>
											<li><span onclick="fnDeprChc('851','예천');">예천</span></li>
											<li><span onclick="fnDeprChc('127','오산');">오산</span></li>
											<li><span onclick="fnDeprChc('575','완도');">완도</span></li>
											<li><span onclick="fnDeprChc('150','용인');">용인</span></li>
											<li><span onclick="fnDeprChc('111','용인신갈');">용인신갈</span></li>
											<li><span onclick="fnDeprChc('149','용인유림');">용인유림</span></li>
											<li><span onclick="fnDeprChc('715','울산');">울산</span></li>
											<li><span onclick="fnDeprChc('716','울산신복');">울산신복</span></li>
											<li><span onclick="fnDeprChc('578','원동');">원동</span></li>
											<li><span onclick="fnDeprChc('240','원주');">원주</span></li>
											<li><span onclick="fnDeprChc('245','원주문막');">원주문막</span></li>
											<li><span onclick="fnDeprChc('244','원주혁신');">원주혁신</span></li>
											<li><span onclick="fnDeprChc('360','유성');">유성</span></li>
											<li><span onclick="fnDeprChc('170','의정부');">의정부</span></li>
											<li><span onclick="fnDeprChc('160','이천');">이천</span></li>
											<li><span onclick="fnDeprChc('171','이천(마장택지지구)');">이천(마장택지지구)</span></li>
											<li><span onclick="fnDeprChc('172','이천부발(신하리)');">이천부발(신하리)</span></li>
											<li><span onclick="fnDeprChc('615','익산');">익산</span></li>
											<li><span onclick="fnDeprChc('616','익산팔봉');">익산팔봉</span></li>
											<li><span onclick="fnDeprChc('325','인삼랜드(휴)상행');">인삼랜드(휴)상행</span></li>
											<li><span onclick="fnDeprChc('324','인삼랜드(휴)하행');">인삼랜드(휴)하행</span></li>
											<li><span onclick="fnDeprChc('100','인천');">인천</span></li>
											<li><span onclick="fnDeprChc('105','인천공항T1');">인천공항T1</span></li>
											<li><span onclick="fnDeprChc('117','인천공항T2');">인천공항T2</span></li>
											<li><span onclick="fnDeprChc('622','자치인재원');">자치인재원</span></li>
											<li><span onclick="fnDeprChc('583','장성');">장성</span></li>
											<li><span onclick="fnDeprChc('580','장흥');">장흥</span></li>
											<li><span onclick="fnDeprChc('621','전북혁신');">전북혁신</span></li>
											<li><span onclick="fnDeprChc('602','전주');">전주</span></li>
											<li><span onclick="fnDeprChc('605','전주호남제일문');">전주호남제일문</span></li>
											<li><span onclick="fnDeprChc('850','점촌');">점촌</span></li>
											<li><span onclick="fnDeprChc('392','정산');">정산</span></li>
											<li><span onclick="fnDeprChc('316','정안(휴)상행');">정안(휴)상행</span></li>
											<li><span onclick="fnDeprChc('315','정안(휴)하행');">정안(휴)하행</span></li>
											<li><span onclick="fnDeprChc('630','정읍');">정읍</span></li>
											<li><span onclick="fnDeprChc('450','제천');">제천</span></li>
											<li><span onclick="fnDeprChc('449','제천하소');">제천하소</span></li>
											<li><span onclick="fnDeprChc('350','조치원');">조치원</span></li>
											<li><span onclick="fnDeprChc('118','죽전');">죽전</span></li>
											<li><span onclick="fnDeprChc('419','중앙탑면');">중앙탑면</span></li>
											<li><span onclick="fnDeprChc('585','지도');">지도</span></li>
											<li><span onclick="fnDeprChc('590','진도');">진도</span></li>
											<li><span onclick="fnDeprChc('722','진주');">진주</span></li>
											<li><span onclick="fnDeprChc('723','진주개양');">진주개양</span></li>
											<li><span onclick="fnDeprChc('724','진주혁신');">진주혁신</span></li>
											<li><span onclick="fnDeprChc('704','진해');">진해</span></li>
											<li><span onclick="fnDeprChc('397','창기리');">창기리</span></li>
											<li><span onclick="fnDeprChc('710','창원');">창원</span></li>
											<li><span onclick="fnDeprChc('711','창원역');">창원역</span></li>
											<li><span onclick="fnDeprChc('310','천안');">천안</span></li>
											<li><span onclick="fnDeprChc('346','천안3공단');">천안3공단</span></li>
											<li><span onclick="fnDeprChc('343','천안아산역');">천안아산역</span></li>
											<li><span onclick="fnDeprChc('391','청양');">청양</span></li>
											<li><span onclick="fnDeprChc('401','청주(센트럴)');">청주(센트럴)</span></li>
											<li><span onclick="fnDeprChc('400','청주고속터미널');">청주고속터미널</span></li>
											<li><span onclick="fnDeprChc('407','청주공항');">청주공항</span></li>
											<li><span onclick="fnDeprChc('250','춘천');">춘천</span></li>
											<li><span onclick="fnDeprChc('420','충주');">충주</span></li>
											<li><span onclick="fnDeprChc('349','탕정삼성LCD');">탕정삼성LCD</span></li>
											<li><span onclick="fnDeprChc('394','태안');">태안</span></li>
											<li><span onclick="fnDeprChc('629','태인');">태인</span></li>
											<li><span onclick="fnDeprChc('730','통영');">통영</span></li>
											<li><span onclick="fnDeprChc('180','평택');">평택</span></li>
											<li><span onclick="fnDeprChc('175','평택대');">평택대</span></li>
											<li><span onclick="fnDeprChc('174','평택용이동');">평택용이동</span></li>
											<li><span onclick="fnDeprChc('830','포항');">포항</span></li>
											<li><span onclick="fnDeprChc('828','포항시청');">포항시청</span></li>
											<li><span onclick="fnDeprChc('834','풍기');">풍기</span></li>
											<li><span onclick="fnDeprChc('581','함평');">함평</span></li>
											<li><span onclick="fnDeprChc('595','해남');">해남</span></li>
											<li><span onclick="fnDeprChc('552','해제');">해제</span></li>
											<li><span onclick="fnDeprChc('354','홍대조치원');">홍대조치원</span></li>
											<li><span onclick="fnDeprChc('389','홍성');">홍성</span></li>
											<li><span onclick="fnDeprChc('586','화순');">화순</span></li>
											<li><span onclick="fnDeprChc('440','황간');">황간</span></li>
											<li><span onclick="fnDeprChc('577','회진');">회진</span></li>
											<li><span onclick="fnDeprChc('239','횡성(휴)상행');">횡성(휴)상행</span></li>
											<li><span onclick="fnDeprChc('238','횡성(휴)하행');">횡성(휴)하행</span></li>
										</ul>
									</div>
									<div class="scroll-element scroll-x scroll-scrolly_visible">
										<div class="scroll-element_outer">
											<div class="scroll-element_size"></div>
											<div class="scroll-element_track"></div>
											<div class="scroll-bar" style="width: 88px;"></div>
										</div>
									</div>
									<div class="scroll-element scroll-y scroll-scrolly_visible">
										<div class="scroll-element_outer">
											<div class="scroll-element_size"></div>
											<div class="scroll-element_track"></div>
											<div class="scroll-bar" style="height: 62px; top: 246.154px;"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="btns" style="padding: 30px 0;"></div>
			</div>
		</div>

		<div class="tic-box ticket-confirm">
			<div id="login-column" class="col-md-6">
				<div id="login-box" class="col-md-12">
					<form id="login-form" class="form" action="" method="post">
						<h3>회원 로그인</h3>
						<div class="form-group">
							<label for="username" class="text-info">아이디</label><br> <input
								type="text" name="username" id="username" class="form-control">
						</div>
						<div class="form-group">
							<label for="password" class="text-info">비밀번호</label><br> <input
								type="text" name="password" id="password" class="form-control">
						</div>
						<div class="form-group">
							<label for="remember-me" class="text-info"><span>Remember
									me</span> <span><input id="remember-me" name="remember-me"
									type="checkbox"></span></label><br> <input type="submit"
								name="submit" class="btn btn-info btn-md" value="로그인">
						</div>
						<span id="register-link" class="text-right"> <a href="#"
							class="text-info">아이디 찾기</a>
						</span> <span id="register-link" class="text-right"> <a href="#"
							class="text-info">비밀번호 찾기</a>
						</span>
					</form>
					<form id="login-form" class="form" action="" method="post">
						<h3>비회원 예매</h3>
						<div class="form-group">
							<label for="username" class="text-info">휴대폰 번호</label><br> <input
								type="text" name="username" id="username" class="form-control">
						</div>
						<div class="form-group">
							<label for="password" class="text-info">비밀번호</label><br> <input
								type="text" name="password" id="password" class="form-control">
						</div>
						<div class="form-group">
							<label for="remember-me" class="text-info"><span>Remember
									me</span> <span><input id="remember-me" name="remember-me"
									type="checkbox"></span></label><br> <input type="submit"
								name="submit" class="btn btn-info btn-md" value="조회하기">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>