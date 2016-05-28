package com.company.amazon.MoreProgramsForAmazon;

public class BuildNAryTreeWithPreAndPost {
	public static BTreeNode constructTree(int[] preorder,int preStart,int preEnd,int[] postorder,int postStart,int postEnd)
	{
		if(preStart>preEnd) return null;
		BTreeNode root=new BTreeNode(preorder[preStart]);
		int preCur=preStart+1;
		int postCur=postStart;
		while(preCur<=preEnd&&postCur<=postEnd-1)
		{
			//BTreeNode child=new BTreeNode(preorder[preCur]);
			int length=0;
			while(postorder[postCur]!=preorder[preCur])
			{
				postCur++;
				length++;
			}
			//postorder[postCur]==preorder[preCur]
			BTreeNode child=constructTree(preorder,preCur,preCur+length,postorder,postCur-length,postCur);
			root.children.add(child);
			postCur++;
			preCur+=length+1;
		}
		return root;
}
}
