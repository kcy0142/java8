var stompClient = null;

function setConnected(connected) {
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
	if (connected) {
		$("#chat").show();
	} else {
		$("#chat").hide();
	}
	$("#chat").html("");
}

//소켓 연결
function connect() {
	var socket = new SockJS('/wonchul-websocket');
	
	var myres = [];

	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		// 입장에 대한 구독
		stompClient.subscribe('/topic/hello2', function(msg) {
			showHello(JSON.parse(msg.body));
		});
		// 입장에 대한 메시지 전달
		stompClient.subscribe('/topic/detail', function(msg) {
			showDetail(JSON.parse(msg.body));
		});
		
		// 서버에서 보내지는 공지
		stompClient.subscribe('/topic/notice', function(msg) {
			showDetail(JSON.parse(msg.body));
		});
		
		// 서버에서 보내지는 LIST
		stompClient.subscribe('/topic/myscores', function(msg) {
			showDetailList(JSON.parse(msg.body));
		});
		
		
		
		// 퇴장에 대한 구독
		stompClient.subscribe('/topic/bye', function(msg) {
			
			showBye(JSON.parse(msg.body));
		});
		sendHello();
	});
}

//소켓 연결 끊음
function disconnect() {
	if (stompClient != null) {
		sendBye();
		stompClient.disconnect();
	}
	setConnected(false);
	
	console.log("Disconnected");
}

function sendHello() {
	stompClient.send("/app/hello2", {}, JSON.stringify({
		name	 : $('#name').val()
	}));
}

function sendDetail() {
	stompClient.send("/app/detail", {}, JSON.stringify({
		name	 : $('#name').val(),
		contents : $('#btn-input').val()
	}));
}

function sendBye() {
	stompClient.send("/app/bye", {}, JSON.stringify({
		name	 : $('#name').val()
	}));
}

function showDetailList(messageList){
	var html = "";
	$(".chatPrice").text("");
	messageList.forEach(function(item) { 
		html += '	<div class="chat-body clearfix">';
		html += '		<strong class="pull-right primary-font">name:'+item["name"]+',runs:'+item["runs"]+',balls:'+item["balls"]+ '</strong>';
		html += '	</div>';
	});
	 $(".chatPrice").append(html);

}

function showDetail(message) {
	var html = "";
	if(message.name == $('#name').val()){
		html += '<li class="left clearfix">';
		html += '	<span class="chat-img pull-right">'
		html += '		<img src="/image/'+  message.imageNo +'.png" alt="User Avatar" class="img-circle"  width="80" height="80">';
		html += '	</span>';
		html += '	<div class="chat-body clearfix">';
		html += '		<div class="header">';
		html += '		<strong class="pull-right primary-font">' + message.name + '</strong>';
		html += '		<small class="text-muted">';
		html += '			<i class="fa fa-clock-o fa-fw"></i>' + new Date(message.sendDate);
		html += '		</small>';
		html += '	</div>';
		html += '	<p>';
		html += 	message.contents;
		html += '	</p>';
		html += '	</div>';
		html += '</li>';
	} else {
		html += '<li class="left clearfix">';
		html += '	<span class="chat-img pull-left">'
		html += '		<img src="/image/'+  message.imageNo +'.png" alt="User Avatar" class="img-circle"  width="80" height="80">';
		html += '	</span>';
		html += '	<div class="chat-body clearfix">';
		html += '		<div class="header">';
		html += '		<strong class="primary-font">' + message.name + '</strong>';
		html += '		<small class="pull-right text-muted">';
		html += '			<i class="fa fa-clock-o fa-fw"></i>' + new Date(message.sendDate);
		html += '		</small>';
		html += '	</div>';
		html += '	<p>';
		html += 	message.contents;
		html += '	</p>';
		html += '	</div>';
		html += '</li>';
	}
	
	$(".chat").append(html);
	$('.panel-body').scrollTop($(".chat")[0].scrollHeight);
}

function showHello(message) {
	var html = "";
	
	html += '<li class="left clearfix">';
	html += '	<div class="chat-body clearfix">';
	html += '	<div class="header">';
	html += '		<strong class="primary-font">' + message.name + '</strong>';
	html += '		<small class="pull-right text-muted">';
	html += '			<i class="fa fa-clock-o fa-fw"></i>' + new Date(message.sendDate);
	html += '		</small>';
	html += '	</div>';
	html += '	<p>';
	html += '	입장 하였습니다';
	html += '	</p>';
	html += '	</div>';
	html += '</li>';
	
	$(".chat").append(html);
	$('.panel-body').scrollTop($(".chat")[0].scrollHeight);
}

function showBye(message) {
	var html = "";
	html += '<li class="left clearfix">';
	html += '	<div class="chat-body clearfix">';
	html += '	<div class="header">';
	html += '		<strong class="primary-font">' + message.name + '</strong>';
	html += '		<small class="pull-right text-muted">';
	html += '			<i class="fa fa-clock-o fa-fw"></i>' + new Date(message.sendDate);
	html += '		</small>';
	html += '	</div>';
	html += '	<p>';
	html += '	퇴장 하였습니다';
	html += '	</p>';
	html += '	</div>';
	html += '</li>';
	
	$(".chat").append(html);
	$('.panel-body').scrollTop($(".chat")[0].scrollHeight);
}

$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	$("#connect").click(function() {
		// 소켓 연결
		connect();
	});
	$("#disconnect").click(function() {
		// 소켓 연결 끊음
		disconnect();
	});
	$("#btn-chat").click(function() {
		// 메시지 전달
		sendDetail();
		$('#btn-input').val('');
	});
});